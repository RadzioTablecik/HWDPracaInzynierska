package com.example.hwdpracainzynierska.user.repository;

import com.example.hwdpracainzynierska.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
