package com.example.CentreDeVaccination.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CentreDeVaccination.Exceptions.ObjectNotFoundException;
import com.example.CentreDeVaccination.Models.Docteur;
import com.example.CentreDeVaccination.Services.DocteurService;

@RestController
@RequestMapping("/docteurs")
public class DocteurRestController {

    private DocteurService docteurService;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Docteur>> getAllDocteurs(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            // Filtrer la liste des docteurs par nom qui commence par la valeur du paramètre
            // 'name'
            List<Docteur> filteredDocteurs = docteurService.findAll()
                    .stream()
                    .filter(docteur -> docteur.getFirstName().startsWith(name))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(filteredDocteurs, HttpStatus.OK);
        } else {
            // Si aucun paramètre 'name' n'est fourni, renvoyer la liste complète des
            // docteurs
            List<Docteur> allDocteurs = docteurService.findAll();
            return new ResponseEntity<>(allDocteurs, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/get/{id}")
    public Docteur getDocteurById(@PathVariable Long id) {
        return docteurService.findOneById(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Docteur> createDocteur(@RequestBody Docteur docteur) {
        Docteur savedDocteur = docteurService.saveDocteur(docteur);
        return new ResponseEntity<>(savedDocteur, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public Docteur updateDocteur(@RequestBody Docteur docteur) {
        return docteurService.update(docteur.getId().longValue(), docteur);
    }

    @DeleteMapping(path = "/delete{id}")
    public void deleteDocteur(@PathVariable Long id) {
        docteurService.delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(ObjectNotFoundException ex) {
        return new ResponseEntity<>("Docteur not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
