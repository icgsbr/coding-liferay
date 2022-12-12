package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.CollaboratorDTO;
import br.com.senac.codingliferay.models.CollaboratorModel;
import br.com.senac.codingliferay.services.CollaboratorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(collaboratorService.save(collaboratorDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region GET
    @GetMapping("collaborator/get/all")
    @ApiOperation(
            value = "Returns all collaborators registered on the database"
    )
    public ResponseEntity<Object> all() {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(collaboratorService.getAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("collaborator/get/name")
    @ApiOperation(value = "Returns a collaborator with the same given name")
    public ResponseEntity<Object> name(@RequestBody String collaboratorName) {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(collaboratorService.getByName(collaboratorName));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("collaborator/get/id")
    @ApiOperation(value = "Returns a collaborator with the same given id")
    public ResponseEntity<Object> name(@RequestBody Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(collaboratorService.getById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region PUT
    @PutMapping("collaborator/put/update")
    @ApiOperation(value = "Update Collaborator")
    public ResponseEntity<Object> updateAll(
            @RequestBody Long id,
            @RequestBody CollaboratorDTO collaboratorDTO
    ) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            collaboratorService
                                    .updateFullCollaborator(
                                            id,
                                            collaboratorDTO
                                    )
                    );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region DELETE
    @DeleteMapping("collaborator/delete/all")
    @ApiOperation(value = "Delete all collaborators registered on the database")
    public ResponseEntity<Object> deleteAll() {
        try {
            collaboratorService.deleteAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("All collaborator registry successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("collaborator/delete/name")
    @ApiOperation(value = "Delete collaborator with the same given name")
    public ResponseEntity<Object> delete(@RequestBody String collaboratorName) {
        try {
            collaboratorService.delete(collaboratorName);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Collaborator successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("collaborator/delete")
    @ApiOperation(value = "Delete collaborator")
    public ResponseEntity<Object> delete(@RequestBody CollaboratorModel collaboratorModel) {
        try {
            collaboratorService.delete(collaboratorModel);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Collaborator successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

}
