package org.mass.Doctor_service.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import org.mass.Doctor_service.entities.Availability;
import org.mass.Doctor_service.entities.Doctor;
import org.mass.Doctor_service.repositories.DoctorRepository;
import org.mass.Doctor_service.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/doctor")
public class DoctorRestAPI {
    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;

    public DoctorRestAPI(DoctorService doctorService, DoctorRepository doctorRepository) {
        this.doctorService = doctorService;
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        return "Doctors";
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

    @GetMapping("/allDocts")
    @PreAuthorize("hasAuthority('ADMIN')")
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




    /*@GetMapping("/mySession")
    public ResponseEntity<Doctor> getSession() {
        // logiques pour récupérer la session
        return ResponseEntity.ok();
    }*/

    @GetMapping("/mySession")
    public ResponseEntity<Authentication> getSession(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }



}
