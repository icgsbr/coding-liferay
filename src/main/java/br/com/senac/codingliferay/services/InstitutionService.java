package br.com.senac.codingliferay.services;

import br.com.senac.codingliferay.dtos.InstitutionDTO;
import br.com.senac.codingliferay.models.InstitutionModel;
import br.com.senac.codingliferay.repositories.InstitutionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitutionService {
    //region INJECTIONS
    @Autowired
    InstitutionRepository institutionRepository;
    //endregion

    //region CREATE
    @Transactional
    @Modifying
    public InstitutionModel save(InstitutionDTO institutionDTO) {
        institutionDTO.setName(institutionDTO.getName().trim().toUpperCase());
        institutionDTO.setCountry(institutionDTO.getCountry().trim().toUpperCase());
        institutionDTO.setState(institutionDTO.getState().trim().toUpperCase());
        institutionDTO.setCity(institutionDTO.getCity().trim().toUpperCase());

        InstitutionModel institutionModel = new InstitutionModel();
        BeanUtils.copyProperties(institutionDTO, institutionModel);

        return institutionRepository.save(institutionModel);
    }
    //endregion

    //region READ
    public List<InstitutionModel> getAll() {
        return institutionRepository.findAll();
    }

    public InstitutionModel getByName(String institutionName) {
        return institutionRepository.findByName(institutionName.toUpperCase());
    }

    public InstitutionModel getById(Long id) {
        return institutionRepository.findById(id).get();
    }
    //endregion

    //region UPDATE
    public InstitutionModel updateFullInstitution(Long id, InstitutionDTO institutionDTO) {
        // TODO: ANALYSE POSSIBILITY OF MAKING UPDATE QUERY INSTEAD THE FOLLOWING LOGIC

        institutionDTO.setName(institutionDTO.getName().trim().toUpperCase());
        institutionDTO.setCountry(institutionDTO.getCountry().trim().toUpperCase());
        institutionDTO.setState(institutionDTO.getState().trim().toUpperCase());
        institutionDTO.setCity(institutionDTO.getCity().trim().toUpperCase());

        InstitutionModel institutionToBeChanged = institutionRepository.findById(id).get();
        BeanUtils.copyProperties(institutionDTO, institutionToBeChanged);
        return institutionToBeChanged;
    }
    //endregion

    //region DELETE
    @Transactional
    @Modifying
    public void deleteAll() {
        institutionRepository.deleteAll();
    }

    @Transactional
    @Modifying
    public void delete(InstitutionModel institutionModel) {
        institutionRepository.delete(institutionModel);
    }

    @Transactional
    @Modifying
    public void delete(String institutionName) {
        institutionRepository.delete(getByName(institutionName.toUpperCase()));
    }
    //endregion
}
