package com.example.CentreDeVaccination.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CentreDeVaccination.Exceptions.ObjectNotFoundException;
import com.example.CentreDeVaccination.Models.Adresse;
import com.example.CentreDeVaccination.Models.Docteur;
import com.example.CentreDeVaccination.Models.Patient;
import com.example.CentreDeVaccination.Repositories.AdresseRepository;

@Service
public class AdresseService {

    public AdresseRepository adresseRepository;
    public DocteurService docteurService;
    public PatientService patientService;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository, DocteurService docteurService,
            PatientService patientService) {
        this.adresseRepository = adresseRepository;
        this.docteurService = docteurService;
        this.patientService = patientService;
    }

    public AdresseService() {

    }

    public Adresse saveAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    public Adresse findOneById(Long id) {
        return adresseRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Adresse not found with id: " + id));
    }

    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    public Adresse update(Long id, Adresse updatedAdresse) {
        return adresseRepository.findById(id)
                .map(adresse -> {
                    adresse.setVille(updatedAdresse.getVille());
                    adresse.setRue(updatedAdresse.getRue());
                    adresse.setZip_code(updatedAdresse.getZip_code());
                    adresse.setDocteur(updatedAdresse.getDocteur());
                    adresse.setPatient(updatedAdresse.getPatient());

                    UpdateDocteurAdresse(updatedAdresse);
                    UpdatePatientAdresse(updatedAdresse);

                    return adresseRepository.save(adresse);
                })
                .orElseThrow(() -> new RuntimeException("Adresse non trouvée !"));
    }

    private void UpdateDocteurAdresse(Adresse updatedAdresse) {
        if (updatedAdresse.getDocteur() != null) {
            Docteur docteur = updatedAdresse.getDocteur();
            docteur.setAdresse(updatedAdresse);
            docteurService.update(updatedAdresse.getDocteur().getId().longValue(), docteur);
        }
    }

    private void UpdatePatientAdresse(Adresse updatedAdresse) {
        if (updatedAdresse.getPatient() != null) {
            Patient patient = updatedAdresse.getPatient();
            patient.setAdresse(updatedAdresse);
            patientService.update(updatedAdresse.getPatient().getId().longValue(), patient);
        }
    }

    public void delete(Long id) {
        Adresse adresseToDelete = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse non trouvée !"));

        // Dissocier l'adresse des entités associées (Docteur et Patient) si nécessaire
        if (adresseToDelete.getDocteur() != null) {
            adresseToDelete.getDocteur().setAdresse(null);
        }

        if (adresseToDelete.getPatient() != null) {
            adresseToDelete.getPatient().setAdresse(null);
        }

        adresseRepository.delete(adresseToDelete);
    }

}
