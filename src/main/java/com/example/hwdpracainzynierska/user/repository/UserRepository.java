package com.example.hwdpracainzynierska.user.repository;

import com.example.hwdpracainzynierska.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
