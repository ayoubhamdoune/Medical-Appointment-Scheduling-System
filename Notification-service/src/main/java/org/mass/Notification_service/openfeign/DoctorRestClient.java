package org.mass.Notification_service.openfeign;


import org.mass.Notification_service.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.mass.Notification_service.model.Doctor;


import java.util.List;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorRestClient {
    @GetMapping(path = "/api/doctor/{id}")
    Doctor getDoctor(@PathVariable(name = "id") Long id);




}
