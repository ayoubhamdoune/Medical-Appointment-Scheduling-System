package org.test.rendezvousservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recipientId;   // ID du destinataire
    private String message;  // Contenu de la notification
    private String status;  // Statut de la notification (par ex. "Envoyée", "Échouée")
    private LocalDateTime sentAt;  // Date et heure d'envoi

    @ManyToOne
    @JoinColumn(name = "Appointment_id")
    private Appointment appointment;



}
