package kodlama.io.DevsApp.webApi.controllers;

import kodlama.io.DevsApp.business.abstracts.SoftwareLangService;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangWithSoftwareTechnologyDTO;
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
@RequestMapping("/api/languages")
public class SoftwareLangController {

    @Inject
    private SoftwareLangService langService;

    @GetMapping()
    public ResponseEntity<List<SoftwareLangDTO>> getAll() {
        return new ResponseEntity<>(langService.getAllLanguage(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SoftwareLangWithSoftwareTechnologyDTO>> getAllLanguageWithTechnology() {
        return new ResponseEntity<>(langService.getAllLanguageWithTechnology(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SoftwareLangDTO> save(@Valid @RequestBody SoftwareLangDTO lang) {
        return new ResponseEntity<>(langService.saveLanguage(lang), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareLangDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(langService.getByLanguageID(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoftwareLangDTO> update(@PathVariable int id, @Valid @RequestBody SoftwareLangDTO lang) {
        return new ResponseEntity<>(langService.updateLanguage(id, lang), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        langService.deleteLanguage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
