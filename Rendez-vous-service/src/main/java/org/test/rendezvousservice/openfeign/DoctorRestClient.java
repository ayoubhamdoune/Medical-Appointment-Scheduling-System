package org.test.rendezvousservice.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.test.rendezvousservice.entities.Doctor;
import java.util.List;

@FeignClient(name = "Doctor-service")
public interface DoctorRestClient {

    @GetMapping(path = "/api/doctors/{id}")
    Doctor getDoctor(@PathVariable(name = "id") Long id);


    @GetMapping(path = "/api/doctors")
    List<Doctor> allDoctors();




}
