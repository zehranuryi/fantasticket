package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
