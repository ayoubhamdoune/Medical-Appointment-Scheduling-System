package org.mass.Patient_service;

import org.mass.Patient_service.entities.Patient;
import org.mass.Patient_service.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner start(PatientRepository patientRepository, RepositoryRestConfiguration RestConfiguration){
return args -> {
	RestConfiguration.exposeIdsFor(Patient.class);
	patientRepository.save(new Patient(null,"AX5555","ayoubH","0767654534",19,"homme"));
	patientRepository.save(new Patient(null,"BX6666","oussama","0767654534",29,"FEMME"));
	patientRepository.save(new Patient(null,"CX7777","triss","0767654534",39,"homme"));
	  patientRepository.findAll().forEach(c->{
		  System.out.println(c.toString());
	  });
};
	};
}
