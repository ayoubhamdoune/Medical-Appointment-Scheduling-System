package org.mass.Notification_service.controllers;

import org.mass.Notification_service.entities.Notification;
import org.mass.Notification_service.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    // Endpoint to get a notification by ID
    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable("id") Long id) {
        return notificationService.getNotificationById(id);
    }

    // Endpoint to create a new notification
    @PostMapping
    public void createNotification(@RequestParam("recipientId") Long recipientId,
                                   @RequestParam("message") String message) {
        notificationService.createNotification(recipientId, message);
    }
}
