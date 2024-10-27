package org.test.rendezvousservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;
import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.repositories.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;


@SpringBootApplication
@EnableFeignClients
public class RendezVousServiceApplication implements CommandLineRunner {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(RendezVousServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        // Insertion d'un rendez-vous
        Appointment appointment = new Appointment();
        appointment.setDoctorId(1L); // Remplace par l'ID du médecin
        appointment.setPatientId(1L); // Remplace par l'ID du patient
        appointment.setAppointmentDate(LocalDateTime.of(2024, 10, 26, 10, 0)); // Date et heure du rendez-vous
        appointment.setStatus("Scheduled");

        // Sauvegarder le rendez-vous dans la base de données
        appointmentRepository.save(appointment);
        System.out.println("Rendez-vous inséré : " + appointment);
    }
}