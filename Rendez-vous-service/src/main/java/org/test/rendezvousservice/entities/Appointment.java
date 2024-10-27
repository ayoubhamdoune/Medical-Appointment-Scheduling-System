package org.test.rendezvousservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentDate;
    private String status;// Par exemple : "Scheduled", "Completed", "Cancelled"
    private String cause;


    @Transient
    private Doctor doctor;
    @Transient
    private Patient patient;



}
