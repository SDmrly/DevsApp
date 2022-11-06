package kodlama.io.DevsApp.webApi.controllers;

import kodlama.io.DevsApp.business.abstracts.SoftwareTechnologyService;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyCreateDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class SoftwareTechnologyController {

    @Inject
    SoftwareTechnologyService technologyService;

    @GetMapping()
    public ResponseEntity<List<SoftwareTechnologyDTO>> getAllTechnology() {
        return new ResponseEntity<>(technologyService.getAllTechnology(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareTechnologyDTO> getByTechnologyID(@PathVariable int id) {
        return new ResponseEntity<>(technologyService.getByTechnologyID(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SoftwareTechnologyCreateDTO> saveTechnology(@Valid @RequestBody SoftwareTechnologyCreateDTO createDTO) {
        return new ResponseEntity<>(technologyService.saveTechnology(createDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoftwareTechnologyDTO> updateTechnology(@PathVariable int id, @Valid @RequestBody SoftwareTechnologyDTO technologyDTO) {
        return new ResponseEntity<>(technologyService.updateTechnology(id, technologyDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable int id) {
        technologyService.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
