package org.mass.Notification_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.mass.Notification_service.model.Patient;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recipientId;   // ID du destinataire
    private String message;  // Contenu de la notification
    private String status;  // Statut de la notification (par ex. "Envoyée", "Échouée")
    private LocalDateTime sentAt;  // Date et heure d'envoi
    @Transient
    private Patient patient;

}
