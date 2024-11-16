package org.mass.Notification_service.openfeign;


import org.mass.Notification_service.model.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RENDEZ-VOUS-SERVICE")
public interface AppointmentRestClient {
    @GetMapping("/api/appointments/{appointmentId}")
    Appointment getAppointment(@PathVariable Long appointmentId);
}
