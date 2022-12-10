package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.CollaboratorDTO;
import br.com.senac.codingliferay.models.CollaboratorModel;
import br.com.senac.codingliferay.services.CollaboratorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class CollaboratorController {
    //region INJECTIONS
    @Autowired
    CollaboratorService collaboratorService;
    //endregion

    //region POST
    @PostMapping ("collaborator/post/register")
    @ApiOperation(value = "Register a new collaborator on the database")
    public ResponseEntity<Object> register(@RequestBody CollaboratorDTO collaboratorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(collaboratorService.save(collaboratorDTO));
    }
    //endregion

    //region GET
    @GetMapping("collaborator/get/all")
    @ApiOperation(value = "Returns all collaborators registered on the database")
    public ResponseEntity<Object> all() {
        return ResponseEntity.status(HttpStatus.FOUND).body(collaboratorService.getAll());
    }

    @GetMapping("collaborator/get/name")
    @ApiOperation(value = "Returns a collaborator with the same given name")
    public ResponseEntity<Object> name(@RequestBody String collaboratorName) {
        return ResponseEntity.status(HttpStatus.FOUND).body(collaboratorService.getByName(collaboratorName));
    }

    @GetMapping("collaborator/get/id")
    @ApiOperation(value = "Returns a collaborator with the same given id")
    public ResponseEntity<Object> name(@RequestBody Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(collaboratorService.getById(id));
    }
    //endregion

    //region PUT
    @PutMapping("collaborator/put/update")
    @ApiOperation(value = "Update Collaborator")
    public ResponseEntity<Object> updateAll(@RequestBody Long id, @RequestBody CollaboratorDTO collaboratorDTO ) {
        return ResponseEntity.status(HttpStatus.OK).body(collaboratorService.updateFullCollaborator(id, collaboratorDTO));
    }
    //endregion

    //region DELETE
    @DeleteMapping("collaborator/delete/all")
    @ApiOperation(value = "Delete all collaborators registered on the database")
    public ResponseEntity<Object> deleteAll() {
        collaboratorService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All collaborator registry successfully erased");
    }

    @DeleteMapping("collaborator/delete/name")
    @ApiOperation(value = "Delete collaborator with the same given name")
    public ResponseEntity<Object> delete(@RequestBody String collaboratorName) {
        collaboratorService.delete(collaboratorName);
        return ResponseEntity.status(HttpStatus.OK).body("Collaborator successfully erased");
    }

    @DeleteMapping("collaborator/delete")
    @ApiOperation(value = "Delete collaborator")
    public ResponseEntity<Object> delete(@RequestBody CollaboratorModel collaboratorModel) {
        collaboratorService.delete(collaboratorModel);
        return ResponseEntity.status(HttpStatus.OK).body("Collaborator successfully erased");
    }
    //endregion

}
