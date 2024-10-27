package org.mass.Notification_service.repository;

import org.mass.Notification_service.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByRecipientId(Long recipientId);

}
