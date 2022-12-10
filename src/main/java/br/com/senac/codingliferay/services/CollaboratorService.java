package br.com.senac.codingliferay.services;

import br.com.senac.codingliferay.dtos.CollaboratorDTO;
import br.com.senac.codingliferay.models.CollaboratorModel;
import br.com.senac.codingliferay.repositories.CollaboratorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollaboratorService {
    //region INJECTIONS
    @Autowired
    CollaboratorRepository collaboratorRepository;
    //endregion

    //region CREATE
    @Transactional
    @Modifying
    public CollaboratorModel save(CollaboratorDTO collaboratorDTO) {
        CollaboratorModel collaboratorModel = new CollaboratorModel();
        BeanUtils.copyProperties(collaboratorDTO, collaboratorModel);
        collaboratorModel.setName(collaboratorModel.getName().toUpperCase());
        return collaboratorRepository.save(collaboratorModel);
    }
    //endregion

    //region READ
    public List<CollaboratorModel> getAll() {
        return collaboratorRepository.findAll();
    }

    public CollaboratorModel getByName(String collaboratorName) {
        return collaboratorRepository.findByName(collaboratorName.toUpperCase());
    }

    public CollaboratorModel getById(Long id) {
        return collaboratorRepository.findById(id).get();
    }
    //endregion

    //region UPDATE
    public CollaboratorModel updateFullCollaborator(Long id, CollaboratorDTO collaboratorDTO) {
        // TODO: ANALYSE POSSIBILITY OF MAKING UPDATE QUERY INSTEAD THE FOLLOWING LOGIC

        CollaboratorModel collaboratorToBeChanged = collaboratorRepository.findById(id).get();
        BeanUtils.copyProperties(collaboratorDTO, collaboratorToBeChanged);
        return collaboratorToBeChanged;
    }
    //endregion

    //region DELETE
    @Transactional
    @Modifying
    public void deleteAll() {
        collaboratorRepository.deleteAll();
    }

    @Transactional
    @Modifying
    public void delete(CollaboratorModel collaboratorModel) {
        collaboratorRepository.delete(collaboratorModel);
    }

    @Transactional
    @Modifying
    public void delete(String collaboratorName) {
        collaboratorRepository.delete(getByName(collaboratorName));
    }
    //endregion
}
