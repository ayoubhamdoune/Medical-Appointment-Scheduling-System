package org.mass.Doctor_service.web;



import org.mass.Doctor_service.entities.Availability;
import org.mass.Doctor_service.entities.Doctor;
import org.mass.Doctor_service.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestAPI {
    private final DoctorService doctorService;

    public DoctorRestAPI(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/saveDoct")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        //Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return doctorService.saveDoctor(doctor) ;
        //ResponseEntity.ok(savedDoctor);
    }

    @PutMapping("/updateDoct/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/{doctorId}/availabilities")
    public List<Availability> getDoctorAvailability(@PathVariable Long doctorId, @RequestParam("date") LocalDateTime date) {
        return doctorService.getDoctorAvailability(doctorId, date);
    }




}
