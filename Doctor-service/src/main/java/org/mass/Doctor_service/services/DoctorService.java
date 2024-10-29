package org.mass.Doctor_service.services;




import org.mass.Doctor_service.entities.Availability;
import org.mass.Doctor_service.entities.Doctor;
import org.mass.Doctor_service.repositories.AvailabilityRepository;
import org.mass.Doctor_service.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    @Autowired
    private AvailabilityRepository availabilityRepository;


    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

   /* public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setSpecialty(updatedDoctor.getSpecialty());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
        doctor.setAddress(updatedDoctor.getAddress());
        return doctorRepository.save(doctor);
    }*/
   public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
       Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));

       // Vérifiez chaque champ et mettez à jour uniquement s'il n'est pas null
       if (updatedDoctor.getFirstName() != null) {
           doctor.setFirstName(updatedDoctor.getFirstName());
       }
       if (updatedDoctor.getLastName() != null) {
           doctor.setLastName(updatedDoctor.getLastName());
       }
       if (updatedDoctor.getSpecialty() != null) {
           doctor.setSpecialty(updatedDoctor.getSpecialty());
       }
       if (updatedDoctor.getEmail() != null) {
           doctor.setEmail(updatedDoctor.getEmail());
       }
       if (updatedDoctor.getPhoneNumber() != null) {
           doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
       }
       if (updatedDoctor.getAddress() != null) {
           doctor.setAddress(updatedDoctor.getAddress());
       }

       return doctorRepository.save(doctor);
   }


    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Availability> getDoctorAvailability(Long doctorId, LocalDateTime date) {
        return availabilityRepository.findByDoctorIdAndStartTimeAfter(doctorId, date);
    }






}

