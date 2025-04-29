package org.lessons.pizzeria.security.pizzeria_security.repository;

import java.util.Optional;

import org.lessons.pizzeria.security.pizzeria_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
