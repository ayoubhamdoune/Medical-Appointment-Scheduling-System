package org.mass.Doctor_service.repositories;

import org.mass.Doctor_service.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Recherche par prénom et nom
    Doctor findByFirstNameAndLastName(String firstName, String lastName);
}