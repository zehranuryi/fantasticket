package com.codecrew.fantasticket.entities.users;


import com.codecrew.fantasticket.enums.UserType;
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
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private int id;

        @Column(name = "user_type")
        private UserType userType;

        @Email
        @NonNull
        @NotBlank
        @Column(name = "email")
        private String email;

        @NonNull
        @NotBlank
        @Column(name = "password")
        private String password;
}
