package org.test.rendezvousservice.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.repositories.NotificationRepository;
import org.test.rendezvousservice.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final NotificationRepository notificationRepository;

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService,NotificationRepository notificationRepository) {
        this.appointmentService = appointmentService;
        this.notificationRepository= notificationRepository;
    }

//--------------------


    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointmentWithNotifications(appointment);
    }
//--------------------


    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime appointmentDate
    ) {
        Appointment appointment = appointmentService.bookAppointment(patientId, doctorId, appointmentDate);
        return ResponseEntity.ok(appointment);
    }
}
