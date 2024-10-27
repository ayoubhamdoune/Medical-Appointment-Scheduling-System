package org.test.rendezvousservice.services;


import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RestTemplate restTemplate; // Pour communiquer avec le Service de Gestion des Médecins

   /*public Appointment scheduleAppointment(Long doctorId, Long patientId, LocalDateTime date) {
        // Vérifie la disponibilité du médecin via le service des médecins
        String url = "http://DOCTOR_SERVICE/api/doctors/" + doctorId + "/availabilities?date=" + date;
        Boolean isAvailable = restTemplate.getForObject(url, Boolean.class);

        if (Boolean.TRUE.equals(isAvailable)) {
            // Si disponible, créer un rendez-vous
            Appointment appointment = new Appointment(null, doctorId, patientId, date, "Scheduled");
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Le médecin n'est pas disponible à cette date");
        }
    }*/
}
