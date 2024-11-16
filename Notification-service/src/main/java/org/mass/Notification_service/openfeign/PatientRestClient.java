package org.mass.Notification_service.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.mass.Notification_service.model.Patient;


@FeignClient(name = "PATIENT-SERVICE")
public interface PatientRestClient {
    @GetMapping("/patients/{patientId}")
    Patient getPatient(@PathVariable Long patientId);


}
