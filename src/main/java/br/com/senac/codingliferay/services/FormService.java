package br.com.senac.codingliferay.services;

import br.com.senac.codingliferay.dtos.FormDTO;
import br.com.senac.codingliferay.models.FormModel;
import br.com.senac.codingliferay.models.InstitutionModel;
import br.com.senac.codingliferay.repositories.FormRepository;
import br.com.senac.codingliferay.repositories.InstitutionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormService {
    //region INJECTIONS
    @Autowired
    FormRepository formRepository;

    @Autowired
    InstitutionRepository institutionRepository;
    //endregion

    //region CREATE
    @Transactional
    @Modifying
    public FormModel save(FormDTO formDTO) {
        formDTO.setNameInstitution(formDTO.getNameInstitution().trim().toUpperCase());
        formDTO.setCountryInstitution(formDTO.getCountryInstitution().trim().toUpperCase());
        formDTO.setStateInstitution(formDTO.getStateInstitution().trim().toUpperCase());
        formDTO.setCityInstitution(formDTO.getCityInstitution().trim().toUpperCase());

        FormModel formModel = new FormModel();
        BeanUtils.copyProperties(formDTO, formModel);

        formModel.setInstitution(saveOrGetInstitution(formDTO));
        formModel.setCollaborator(formRepository.getCollaborator("AMANDA GOUVEIA").get());

        return formRepository.save(formModel);
    }
    //endregion

    //region READ
    public List<FormModel> getAll() {
        return formRepository.findAll();
    }

    public FormModel getById(Long id) {
        return formRepository.findById(id).get();
    }
    //endregion

    //region PUT
    public FormModel updateAll(Long id, FormDTO formDTO) {
        formDTO.setNameInstitution(formDTO.getNameInstitution().trim().toUpperCase());
        formDTO.setCountryInstitution(formDTO.getCountryInstitution().trim().toUpperCase());
        formDTO.setStateInstitution(formDTO.getStateInstitution().trim().toUpperCase());
        formDTO.setCityInstitution(formDTO.getCityInstitution().trim().toUpperCase());

        FormModel formModelToBeChanged = formRepository.findById(id).get();
        BeanUtils.copyProperties(formDTO, formModelToBeChanged);
        return formModelToBeChanged;
    }
    //endregion

    //region DELETE
    @Transactional
    @Modifying
    public void deleteAll() {
        formRepository.deleteAll();
    }

    @Transactional
    @Modifying
    public void delete(FormModel formModel) {
        formRepository.delete(formModel);
    }
    //endregion

    //region ANOTHER METHODS
    public InstitutionModel saveOrGetInstitution(FormDTO formDTO) {
        if (formRepository.getInstitution(formDTO.getNameInstitution()).isPresent()) {
            return formRepository.getInstitution(formDTO.getNameInstitution()).get();
        }

        InstitutionModel institutionModel = new InstitutionModel(
                formDTO.getNameInstitution(),
                formDTO.getEmailInstitution(),
                formDTO.getPhoneNumberInstitution(),
                formDTO.getCityInstitution(),
                formDTO.getStateInstitution(),
                formDTO.getCountryInstitution()
        );

        return institutionRepository.save(institutionModel);
    }

    public Double getAmountDonated() {
        try {
            return formRepository.getAmountDonated();
        } catch (Exception e) {
            return 0.0;
        }
    }
    //endregion
}
