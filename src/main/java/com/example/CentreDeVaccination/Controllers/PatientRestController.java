package com.example.CentreDeVaccination.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.CentreDeVaccination.Exceptions.ObjectNotFoundException;
import com.example.CentreDeVaccination.Models.Docteur;
import com.example.CentreDeVaccination.Models.Patient;
import com.example.CentreDeVaccination.Services.PatientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Patient>> getAllPatients(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            // Filtrer la liste des patients par nom qui commence par la valeur du paramètre
            // 'name'
            List<Patient> filteredPatients = patientService.findAll()
                    .stream()
                    .filter(patient -> patient.getFirstName().startsWith(name))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(filteredPatients, HttpStatus.OK);
        } else {
            // Si aucun paramètre 'name' n'est fourni, renvoyer la liste complète des
            // patients
            List<Patient> allPatients = patientService.findAll();
            return new ResponseEntity<>(allPatients, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findOneById(id);
    }

    @PostMapping(path = "/create", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.update(patient.getId().longValue(), patient);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(ObjectNotFoundException ex) {
        return new ResponseEntity<>("Patient not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/getDocteur/{id}")
    public Docteur getDocteur(@PathVariable Long id) {
        return patientService.getDocteur(id);
    }

}
