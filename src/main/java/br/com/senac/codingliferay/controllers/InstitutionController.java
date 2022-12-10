package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.InstitutionDTO;
import br.com.senac.codingliferay.models.InstitutionModel;
import br.com.senac.codingliferay.services.InstitutionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionService.save(institutionDTO));
    }
    //endregion

    //region GET
    @GetMapping("institution/get/all")
    @ApiOperation(value = "Returns all institutions registered on the database")
    public ResponseEntity<Object> all() {
        return ResponseEntity.status(HttpStatus.FOUND).body(institutionService.getAll());
    }

    @GetMapping("institution/get/name")
    @ApiOperation(value = "Returns a institution with the same given name")
    public ResponseEntity<Object> name(@RequestBody String institutionName) {
        return ResponseEntity.status(HttpStatus.FOUND).body(institutionService.getByName(institutionName));
    }

    @GetMapping("institution/get/id")
    @ApiOperation(value = "Returns a institution with the same given id")
    public ResponseEntity<Object> name(@RequestBody Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(institutionService.getById(id));
    }
    //endregion

    //region PUT
    @PutMapping("institution/put/update")
    @ApiOperation(value = "Update institution")
    public ResponseEntity<Object> update(@RequestBody Long id, @RequestBody InstitutionDTO institutionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(institutionService.updateFullInstitution(id, institutionDTO));
    }
    //endregion

    //region DELETE
    @DeleteMapping("institution/delete/all")
    @ApiOperation(value = "Delete all institutions registered on the database")
    public ResponseEntity<Object> deleteAll() {
        institutionService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All institution registry successfully erased");
    }

    @DeleteMapping("institution/delete/name")
    @ApiOperation(value = "Delete institution with the same given name")
    public ResponseEntity<Object> delete(@RequestBody String institutionName) {
        institutionService.delete(institutionName);
        return ResponseEntity.status(HttpStatus.OK).body("Institution successfully erased");
    }

    @DeleteMapping("institution/delete")
    @ApiOperation(value = "Delete institution")
    public ResponseEntity<Object> delete(@RequestBody InstitutionModel institutionModel) {
        institutionService.delete(institutionModel);
        return ResponseEntity.status(HttpStatus.OK).body("Institution successfully erased");
    }
    //endregion
}
