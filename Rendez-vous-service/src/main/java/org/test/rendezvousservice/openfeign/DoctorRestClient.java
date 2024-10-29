package org.test.rendezvousservice.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.test.rendezvousservice.entities.Availability;
import org.test.rendezvousservice.entities.Doctor;
import java.util.List;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorRestClient {

    @GetMapping(path = "/api/doctor/{id}")
    Doctor getDoctor(@PathVariable(name = "id") Long id);


    @GetMapping(path = "/api/doctor")
    List<Doctor> allDoctors();

    @GetMapping("/doctors/{doctorId}/availabilities")
    List<Availability> getAvailabilities(@PathVariable Long doctorId);




}
