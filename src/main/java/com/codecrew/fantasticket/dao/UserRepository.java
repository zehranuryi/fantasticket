package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}