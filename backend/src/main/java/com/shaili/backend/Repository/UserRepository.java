package com.shaili.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaili.backend.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
       Optional<User> findByEmail(String email);
       boolean existsByEmail(String email);
}
