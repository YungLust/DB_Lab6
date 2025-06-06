package com.example.DB_Lab6.repository;

import com.example.DB_Lab6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByLogin(String login);
}
