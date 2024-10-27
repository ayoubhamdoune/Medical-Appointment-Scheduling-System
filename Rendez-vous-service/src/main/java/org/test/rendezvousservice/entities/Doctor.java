package org.test.rendezvousservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Long id;//=iDdoctor
    private String firstName;
    private String lastName;
    private String specialty;
    private String email;
    private String phoneNumber;
    private String address;

}
