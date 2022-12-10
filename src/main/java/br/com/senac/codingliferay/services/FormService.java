package br.com.senac.codingliferay.services;

import br.com.senac.codingliferay.dtos.FormDTO;
import br.com.senac.codingliferay.models.FormModel;
import br.com.senac.codingliferay.repositories.FormRepository;
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
    //endregion

    //region CREATE
    @Transactional
    @Modifying
    public FormModel save(FormDTO formDTO) {

        FormModel formModel = new FormModel();
        BeanUtils.copyProperties(formDTO, formModel);
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
}
