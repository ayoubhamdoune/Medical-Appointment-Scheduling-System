package org.test.rendezvousservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.entities.Availability;
import org.test.rendezvousservice.entities.Notification;
import org.test.rendezvousservice.openfeign.DoctorRestClient;
import org.test.rendezvousservice.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.test.rendezvousservice.repositories.NotificationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final DoctorRestClient doctorRestClient;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private NotificationRepository notificationRepository;


    public AppointmentService(DoctorRestClient doctorRestClient, AppointmentRepository appointmentRepository) {
        this.doctorRestClient = doctorRestClient;
        this.appointmentRepository = appointmentRepository;
    }
    //-------------


    public Appointment createAppointmentWithNotifications(Appointment appointment) {
        // Save the Appointment
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Generate Notification
        Notification notification = new Notification();
        notification.setRecipientId(appointment.getPatientId());
        notification.setMessage("Your appointment is scheduled for " + appointment.getAppointmentDate());
        notification.setStatus("Scheduled");
        notification.setSentAt(LocalDateTime.now());
        notification.setAppointment(savedAppointment);

        // Save the Notification
        notificationRepository.save(notification);

        // Attach notification to the appointment for response purposes
        List<Notification> notifications = new ArrayList<>();
        notifications.add(notification);
        savedAppointment.setNotification(notifications);

        return savedAppointment;
    }
    //-------------










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
