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
@Table(name = "customer")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private int id;

        @Email
        @NonNull
        @NotBlank
        @Column(name = "customer_email")
        private String email;

        @NonNull
        @NotBlank
        @Column(name = "customer_password")
        private String password;
}
