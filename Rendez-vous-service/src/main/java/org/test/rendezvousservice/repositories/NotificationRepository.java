package org.test.rendezvousservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.test.rendezvousservice.entities.Appointment;
import org.test.rendezvousservice.entities.Notification;
@Repository
@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
