package org.mass.Doctor_service.repositories;


import org.mass.Doctor_service.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.time.LocalDateTime;

@RepositoryRestResource
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByDoctorIdAndStartTimeAfter(Long doctorId, LocalDateTime date);
}
