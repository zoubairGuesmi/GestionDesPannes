package com.pannes.gestiondespannes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 8)
    private String password;
}
