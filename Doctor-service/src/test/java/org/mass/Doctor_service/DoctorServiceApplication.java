package org.mass.Doctor_service;



import org.mass.Doctor_service.entities.Availability;
import org.mass.Doctor_service.entities.Doctor;
import org.mass.Doctor_service.services.DoctorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class DoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(DoctorService doctorService) {
		return args -> {
			// Créer des médecins avec des disponibilités nulles pour l'instant
			Doctor doctor1 = new Doctor(null, "John", "Doe", "Cardiology", "john.doe@example.com", "123456789", "123 Main St", null);
			Doctor doctor2 = new Doctor(null, "Jane", "Doe", "Neurology", "jane.doe@example.com", "987654321", "456 Elm St", null);

			// Enregistrer les médecins
			doctorService.saveDoctor(doctor1);
			doctorService.saveDoctor(doctor2);

			// Créer des disponibilités pour John Doe
			Availability availability1 = new Availability(null, LocalDateTime.of(2024, 10, 27, 9, 0), LocalDateTime.of(2024, 10, 27, 10, 0), doctor1);
			Availability availability2 = new Availability(null, LocalDateTime.of(2024, 10, 27, 11, 0), LocalDateTime.of(2024, 10, 27, 12, 0), doctor1);

			// Créer des disponibilités pour Jane Doe
			Availability availability3 = new Availability(null, LocalDateTime.of(2024, 10, 27, 13, 0), LocalDateTime.of(2024, 10, 27, 14, 0), doctor2);
			Availability availability4 = new Availability(null, LocalDateTime.of(2024, 10, 27, 15, 0), LocalDateTime.of(2024, 10, 27, 16, 0), doctor2);

			// Ajouter les disponibilités aux médecins
			doctor1.setAvailabilities(Arrays.asList(availability1, availability2));
			doctor2.setAvailabilities(Arrays.asList(availability3, availability4));

			// Enregistrer les disponibilités via les médecins
			doctorService.saveDoctor(doctor1);
			doctorService.saveDoctor(doctor2);
		};
	}


}
