package com.example.CentreDeVaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.CentreDeVaccination.Others.AppConfig;
import com.example.CentreDeVaccination.Others.PatientDataBase;
import com.example.CentreDeVaccination.Services.PatientService;

@SpringBootApplication
public class AppMain2 {

    public static void main(String[] args) {

        SpringApplication.run(AppMain2.class, args);

        // Chargez le contexte Spring à partir de la configuration Java
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // Bean singleton
            PatientService patientService = context.getBean(PatientService.class);

            // Beans prototypes
            PatientDataBase patientDataBase1 = context.getBean(PatientDataBase.class);
            PatientDataBase patientDataBase2 = context.getBean(PatientDataBase.class);

            // Vérification du fonctionnement des Beans
            System.out.println("Référence mémoire du bean Singleton: " + patientService);
            System.out.println("Référence mémoire du 1er bean prototype: " + patientDataBase1);
            System.out.println("Référence mémoire du 2e bean prototype: " + patientDataBase2);

            ((AnnotationConfigApplicationContext) context).close();
        }

        // System.exit(0);

    }
}