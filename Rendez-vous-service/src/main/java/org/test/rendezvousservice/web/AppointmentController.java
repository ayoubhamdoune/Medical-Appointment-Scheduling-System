package org.test.rendezvousservice.web;



import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment scheduleAppointment(@RequestParam Long doctorId,
                                           @RequestParam Long patientId,
                                           @RequestParam("date") LocalDateTime date) {
        return appointmentService.scheduleAppointment(doctorId, patientId, date);
    }
}
