package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	
}