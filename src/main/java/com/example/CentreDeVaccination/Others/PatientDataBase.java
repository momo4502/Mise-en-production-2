package com.example.CentreDeVaccination.Others;

import org.springframework.stereotype.Repository;

@Repository
public class PatientDataBase implements PatientStore {

    @Override
    public void initialize() {
        System.out.println("PatientStore: Méthode d'initialisation appelée");
    }

    @Override
    public void close() {
        System.out.println("PatientStore: Méthode de destruction appelée");
    }

}
