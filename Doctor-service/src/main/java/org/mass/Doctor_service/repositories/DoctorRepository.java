package org.mass.Doctor_service.repositories;

import org.mass.Doctor_service.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Recherche par prénom et nom
    Doctor findByFirstNameAndLastName(String firstName, String lastName);
}