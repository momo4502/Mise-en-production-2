package com.example.CentreDeVaccination.Others;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.CentreDeVaccination.Services.PatientService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = "com.example.PatientManagerAppSpring")
@PropertySource("classpath:application.yaml")
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PatientStore store() {
        System.out.println("PatientStore: Bean prototype créé");
        return new PatientDataBase();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PatientService service(PatientStore store) {
        System.out.println("PatientService: Bean singleton créé");
        return new PatientService();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PatientSerialization serializeStore() {
        return new PatientSerialization();
    }

    @PostConstruct
    public void init() {
        System.out.println("PatientDataBase - init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PatientDatabase - destroy");
    }

}
