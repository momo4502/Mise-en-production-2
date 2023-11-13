package com.example.CentreDeVaccination.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CentreDeVaccination.Models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
