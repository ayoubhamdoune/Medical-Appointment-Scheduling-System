package org.mass.Notification_service.services;

import org.mass.Notification_service.repository.NotificationRepository;
import org.mass.Notification_service.entities.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    // Method to retrieve a notification by its ID


    // Method to create a new notification
    public Notification createNotification(Long recipientId, String message) {
        Notification notification = new Notification();
        notification.setRecipientId(recipientId);
        notification.setMessage(message);
        notification.setStatus("En attente");
        notification.setSentAt(null);
        return notificationRepository.save(notification);
    }




    public Notification sendNotification(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            notification.setStatus("Envoyée");
            notification.setSentAt(LocalDateTime.now());
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Notification non trouvée");
        }
    }

    public Notification updateStatus(Long notificationId, String status) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            notification.setStatus(status);
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Notification non trouvée");
        }
    }
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }
}

