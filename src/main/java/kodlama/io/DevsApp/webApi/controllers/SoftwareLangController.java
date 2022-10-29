package kodlama.io.DevsApp.webApi.controllers;

import kodlama.io.DevsApp.business.abstracts.SoftwareLangService;
import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
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
import java.util.List;

@RestController
@RequestMapping("/api")
public class SoftwareLangController {

    @Inject
    SoftwareLangService langService;

    @GetMapping("/languages")
    public ResponseEntity<List<SoftwareLang> > getAll() {
        return new ResponseEntity<>(langService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/languages")
    public ResponseEntity<SoftwareLang> save(@RequestBody SoftwareLang lang) throws Exception {
        return new ResponseEntity<>(langService.save(lang), HttpStatus.CREATED);
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<SoftwareLang> getById(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(langService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<SoftwareLang> update(@PathVariable int id, SoftwareLang lang) throws Exception {
        return new ResponseEntity<>(langService.update(id, lang), HttpStatus.CREATED);
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        langService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
