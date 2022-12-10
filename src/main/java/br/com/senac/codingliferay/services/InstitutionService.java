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
        InstitutionModel institutionModel = new InstitutionModel();
        BeanUtils.copyProperties(institutionDTO, institutionModel);
        institutionModel.setName(institutionModel.getName().toUpperCase());
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

    public InstitutionModel getByName(InstitutionModel institutionModel) {
        return institutionRepository.findByName(institutionModel.getName().toUpperCase());
    }
    //endregion

    //region UPDATE
    public InstitutionModel updateFullInstitution(Long id, InstitutionDTO institutionDTO) {
        // TODO: ANALYSE POSSIBILITY OF MAKING UPDATE QUERY INSTEAD THE FOLLOWING LOGIC

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
        institutionRepository.delete(getByName(institutionName));
    }
    //endregion
}
