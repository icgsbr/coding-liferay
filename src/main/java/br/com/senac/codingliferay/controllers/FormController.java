package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.FormDTO;
import br.com.senac.codingliferay.models.FormModel;
import br.com.senac.codingliferay.services.FormService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class FormController {
    //region INJECTABLES
    @Autowired
    FormService formService;
    //endregion

    //region POST
    @PostMapping("form/post/register")
    @ApiOperation(value = "Register a new Form on the database")
    public ResponseEntity<Object> register(@RequestBody FormDTO formDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(formService.save(formDTO));
    }
    //endregion

    //region GET
    @GetMapping("form/get/all")
    @ApiOperation(value= "Returns all forms registered on the database")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(formService.getAll());
    }

    @GetMapping("form/get/id")
    @ApiOperation(value = "Returns a form with the same given id")
    public ResponseEntity<Object> id(@RequestBody Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(formService.getById(id));
    }
    //endregion

    //region PUT
    @PutMapping("form/put/update")
    @ApiOperation(value = "Update Form")
    public ResponseEntity<Object> update(@RequestBody Long id, @RequestBody FormDTO formDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(formService.updateAll(id, formDTO));
    }
    //endregion

    //region DELETE
    @DeleteMapping("form/delete/all")
    @ApiOperation(value = "Delete all forms registered on the database")
    public ResponseEntity<Object> deleteAll() {
        formService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All institution registry successfully erased");
    }

    @DeleteMapping("form/delete")
    @ApiOperation(value = "Delete form")
    public ResponseEntity<Object> delete(@RequestBody FormModel formModel) {
        formService.delete(formModel);
        return ResponseEntity.status(HttpStatus.OK).body("Form successfully erased");
    }
    //endregion
}
