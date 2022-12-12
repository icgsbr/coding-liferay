package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.InstitutionDTO;
import br.com.senac.codingliferay.models.InstitutionModel;
import br.com.senac.codingliferay.services.InstitutionService;
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
public class InstitutionController {
    //region INJECTIONS
    @Autowired
    InstitutionService institutionService;
    //endregion

    //region POST
    @PostMapping("institution/post/register")
    @ApiOperation(value = "Returns ")
    public ResponseEntity<Object> register(@RequestBody InstitutionDTO institutionDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(institutionService.save(institutionDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region GET
    @GetMapping("institution/get/all")
    @ApiOperation(value = "Returns all institutions registered on the database")
    public ResponseEntity<Object> all() {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(institutionService.getAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("institution/get/name")
    @ApiOperation(value = "Returns a institution with the same given name")
    public ResponseEntity<Object> name(@RequestBody String institutionName) {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(institutionService.getByName(institutionName));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("institution/get/id")
    @ApiOperation(value = "Returns a institution with the same given id")
    public ResponseEntity<Object> name(@RequestBody Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(institutionService.getById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region PUT
    @PutMapping("institution/put/update")
    @ApiOperation(value = "Update institution")
    public ResponseEntity<Object> update(@RequestBody Long id, @RequestBody InstitutionDTO institutionDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(institutionService.updateFullInstitution(id, institutionDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region DELETE
    @DeleteMapping("institution/delete/all")
    @ApiOperation(value = "Delete all institutions registered on the database")
    public ResponseEntity<Object> deleteAll() {
        try {
            institutionService.deleteAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("All institution registry successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("institution/delete/name")
    @ApiOperation(value = "Delete institution with the same given name")
    public ResponseEntity<Object> delete(@RequestBody String institutionName) {
        try {
            institutionService.delete(institutionName);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Institution successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("institution/delete")
    @ApiOperation(value = "Delete institution")
    public ResponseEntity<Object> delete(
            @RequestBody InstitutionModel institutionModel
    ) {
        try {
            institutionService.delete(institutionModel);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Institution successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion
}
