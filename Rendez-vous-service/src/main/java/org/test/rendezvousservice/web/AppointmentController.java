package org.test.rendezvousservice.web;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

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
