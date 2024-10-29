package org.mass.Doctor_service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Availability> availabilities;

    // Nouveau constructeur pour inclure les disponibilités..
    public Doctor(Long id, String firstName, String lastName, String specialty, String email, String phoneNumber, String address, List<Availability> availabilities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.availabilities = availabilities;
    }
}
