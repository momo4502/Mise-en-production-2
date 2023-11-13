package com.example.CentreDeVaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.CentreDeVaccination.Services.PatientService;

@SpringBootApplication
public class CentreDeVaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreDeVaccinationApplication.class, args);

		// Chargez le contexte Spring en chargeant le fichier beans.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// Récupérez les beans du contexte
		PatientService patientService = (PatientService) context.getBean("patientService");

		// Utilisez les beans
		patientService.methodeTest();

		// Récupérez les deux bean singletons
		PatientService singletonBean1 = (PatientService) context.getBean("patientService");
		PatientService singletonBean2 = (PatientService) context.getBean("patientService");

		// Afichez leurs références mémoires
		System.out.println("Référence mémoire du 1er bean: " + singletonBean1);
		System.out.println("Référence mémoire du 2e bean: " + singletonBean2);

		// Vérifiez si les deux références pointent vers le même objet
		Boolean estLeMemeBean = (singletonBean1 == singletonBean2);
		System.out.println("Les deux beans pointent vers le même objet: " + estLeMemeBean);

		// Fermez proprement le contexte Spring lorsqu'il n'est plus nécessaire
		((ClassPathXmlApplicationContext) context).close();

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				CentreDeVaccinationApplication.class)) {
			// Utilisez le contexte Spring ici
		}
	}

}
