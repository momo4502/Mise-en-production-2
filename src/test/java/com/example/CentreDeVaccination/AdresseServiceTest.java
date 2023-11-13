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

    @Test
    @Transactional
    void testDeletePatient() {
        // Créer un patient avec une adresse
        patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");

        adresse = new Adresse();
        adresse.setVille("Paris");
        adresse.setRue("123 Rue de la Rue");
        adresse.setZip_code(75000);

        patient.setAdresse(adresse);

        // Enregistrer le patient et l'adresse dans la base de données
        patient = patientRepository.save(patient);
        adresse = adresseRepository.save(adresse);

        // Assurez-vous que le patient existe dans la base de données
        assertTrue(patientRepository.existsById(patient.getId().longValue()));

        // Supprimer le patient
        patientRepository.deleteById(patient.getId().longValue());
        assertThrows(Exception.class, () -> patientRepository.deleteById(patient.getId().longValue()));

        // Vérifier que le patient a été supprimé de la base de données
        assertFalse(patientRepository.existsById(patient.getId().longValue()));
    }
}
