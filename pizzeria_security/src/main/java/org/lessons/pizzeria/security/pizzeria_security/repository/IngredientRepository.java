package org.lessons.pizzeria.security.pizzeria_security.repository;

import java.util.List;

import org.lessons.pizzeria.security.pizzeria_security.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
        
    // ricerca per nome, containing e ignore case
    public List<Ingredient> findByNameContainingIgnoreCase(String name);
}
