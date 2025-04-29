package org.lessons.pizzeria.security.pizzeria_security.repository;

import java.util.List;

import org.lessons.pizzeria.security.pizzeria_security.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    
    // ricerca per nome, containing e ignore case
    public List<Pizza> findByNameContainingIgnoreCase(String name);
}
