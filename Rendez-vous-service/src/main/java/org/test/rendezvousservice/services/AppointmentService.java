package org.test.rendezvousservice.services;


import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.entities.Availability;
import org.test.rendezvousservice.openfeign.DoctorRestClient;
import org.test.rendezvousservice.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final DoctorRestClient doctorRestClient;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(DoctorRestClient doctorRestClient, AppointmentRepository appointmentRepository) {
        this.doctorRestClient = doctorRestClient;
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment bookAppointment(Long patientId, Long doctorId, LocalDateTime appointmentDate) {
        // Fetch doctor availability
        List<Availability> availabilities = doctorRestClient.getAvailabilities(doctorId);

        // Check if the requested appointmentDate is within an available slot
        for (Availability availability : availabilities) {
            if (appointmentDate.isAfter(availability.getStartTime()) && appointmentDate.isBefore(availability.getEndTime())) {
                // Book the appointment
                Appointment appointment = new Appointment();
                appointment.setPatientId(patientId);
                appointment.setDoctorId(doctorId);
                appointment.setAppointmentDate(appointmentDate);
                return appointmentRepository.save(appointment);
            }
        }
        throw new RuntimeException("No available slots for the requested time.");
    }
}
