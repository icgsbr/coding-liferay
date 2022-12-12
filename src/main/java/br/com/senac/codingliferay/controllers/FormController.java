package br.com.senac.codingliferay.controllers;

import br.com.senac.codingliferay.dtos.EditFormDTO;
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
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(formService.save(formDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region GET
    @GetMapping("form/get/all")
    @ApiOperation(value= "Returns all forms registered on the database")
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(formService.getAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("form/get/{id}")
    @ApiOperation(value = "Returns a form with the same given id")
    public ResponseEntity<Object> id(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(formService.getById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("form/get/amount")
    @ApiOperation(value = "Returns the donations total sum")
    public ResponseEntity<Object> amount() {
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(formService.getAmountDonated());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(0);
        }
    }
    //endregion

    //region PUT
    @PutMapping("form/put/update/{id}")
    @ApiOperation(value = "Update Form")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody FormDTO formDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(formService.updateAll(id, formDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @PutMapping("form/put/update/lean/{id}")
    @ApiOperation(value = "Update Form")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EditFormDTO editFormDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(formService.updateAll(id, editFormDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion

    //region DELETE
    @DeleteMapping("form/delete/all")
    @ApiOperation(value = "Delete all forms registered on the database")
    public ResponseEntity<Object> deleteAll() {
        try {
            formService.deleteAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("All institution registry successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("form/delete")
    @ApiOperation(value = "Delete form")
    public ResponseEntity<Object> delete(@RequestBody FormModel formModel) {
        try {
            formService.delete(formModel);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Form successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("form/delete/{id}")
    @ApiOperation(value = "Delete form")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            formService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Form successfully erased");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
    //endregion
}
