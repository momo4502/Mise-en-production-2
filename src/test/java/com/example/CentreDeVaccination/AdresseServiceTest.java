package com.example.CentreDeVaccination;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CentreDeVaccination.Models.Adresse;
import com.example.CentreDeVaccination.Models.Patient;
import com.example.CentreDeVaccination.Repositories.AdresseRepository;
import com.example.CentreDeVaccination.Repositories.PatientRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class AdresseServiceTest {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    private Patient patient;
    private Adresse adresse;


}
