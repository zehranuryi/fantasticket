package com.codecrew.fantasticket.entities.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Email
    @NonNull
    @NotBlank
    @Column(name = "admin_email")
    private String email;

    @NonNull
    @NotBlank
    @Column(name = "admin_password")
    private String password;
}
