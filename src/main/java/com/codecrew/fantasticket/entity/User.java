package com.codecrew.fantasticket.entity;


import com.codecrew.fantasticket.entity.base.BaseEntity;
import com.codecrew.fantasticket.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
        
        @Column(name = "username", unique = true, nullable = false)
        private String username;
        
        @Column(name = "email", unique = true, nullable = false)
        private String email;
        
        @Column(name = "phone", nullable = false)
        private String phone;
        
        @Column(name = "address")
        private String address;
        
        @Column(name = "full_name", nullable = false)
        private String fullName;
        
        @Column(name = "password", nullable = false)
        private String password;
        
        @Column(name = "role", nullable = false)
        @Enumerated(EnumType.STRING)
        private Role role;
        
        @Column(name = "active", nullable = false)
        private Boolean active;
        
        public String getUsername() {
                return username;
        }
        
        public void setUsername(String username) {
                this.username = username;
        }
        
        public String getEmail() {
                return email;
        }
        
        public void setEmail(String email) {
                this.email = email;
        }
        
        public String getPhone() {
                return phone;
        }
        
        public void setPhone(String phone) {
                this.phone = phone;
        }
        
        public String getAddress() {
                return address;
        }
        
        public void setAddress(String address) {
                this.address = address;
        }
        
        public String getFullname() {
                return fullName;
        }
        
        public void setFullname(String fullname) {
                this.fullName = fullname;
        }
        
        public String getPassword() {
                return password;
        }
        
        public void setPassword(String password) {
                this.password = password;
        }
        
        public Role getRole() {
                return role;
        }
        
        public void setRole(Role role) {
                this.role = role;
        }
        
        public Boolean getActive() {
                return active;
        }
        
        public void setActive(Boolean active) {
                this.active = active;
        }
}