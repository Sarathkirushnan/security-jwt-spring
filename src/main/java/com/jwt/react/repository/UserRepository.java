package com.jwt.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.react.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
boolean existsByUsername(String username);
boolean existsByEmail(String email);

}
