package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.Ingredient;
import pl.coderslab.model.User;
import pl.coderslab.repository.IngredientRepository;
import pl.coderslab.repository.UserRepository;

public class IngredientGroupConverter implements Converter<String, Ingredient> {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Override
	public Ingredient convert(String source) {
	Ingredient ingredient = ingredientRepository.findOne(Long.parseLong(source));
	        return ingredient;
	    }
}

