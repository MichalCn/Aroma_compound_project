package pl.coderslab.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.Combination;
import pl.coderslab.model.Ingredient;
import pl.coderslab.model.Pairing;
import pl.coderslab.repository.IngredientRepository;
import pl.coderslab.repository.PairingRepository;

@Service
public class RecipeGenerator {
	
	@Autowired
	PairingRepository pairingRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	public Double getCombinationRatio(List<Ingredient> ingredients) {
		Double ratio = 1.0;
		int counter = 0;
		
		for (int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			for (int j = i+1; j < ingredients.size(); j++) {
				Ingredient ingredientToCompare = ingredients.get(j);
				if (ingredient != ingredientToCompare) {
					Pairing pairing = pairingRepository.findFirstByIngredient1IdAndIngredient2Id(ingredient.getId(), ingredientToCompare.getId());
					if (pairing == null) {
						pairing = pairingRepository.findFirstByIngredient1IdAndIngredient2Id(ingredientToCompare.getId(), ingredient.getId());
					}
					ratio *= pairing.getRel();
					counter++;
				}
				
			}
		}
		System.out.println("Counter: "+counter);
		return ratio;
	}
	
	public Ingredient getMatchingIngredient(List<Ingredient> ingredients, List<Ingredient> notliked) {
		
		List<Pairing> pairingsListMain = new ArrayList<>();
		
		pairingsListMain = pairingRepository.findByIngredient1Id(ingredients.get(0).getId());
		List<Pairing> pairingsToRemove = new ArrayList<>();
		for (int i =0; i < pairingsListMain.size(); i++) {
			for (Ingredient ingredient : ingredients) {
				if (ingredient.getId() == pairingsListMain.get(i).getIngredient2().getId()) {
					pairingsToRemove.add(pairingsListMain.get(i));
					
				}
			}
		}
		for (Pairing pairing : pairingsToRemove) {
			pairingsListMain.remove(pairing);
		}
		
		
		Ingredient matchingIngredient = null;
		List<Pairing> pairingsList = new ArrayList<>();
		Double newRatio = 0.0;
		Double tempRatio = 0.0;
		String checkedIngredients = "";
		
		for (Pairing pairingMain : pairingsListMain) {
			Ingredient ingredientToCheck = pairingMain.getIngredient2();		
			tempRatio = pairingMain.getRel();
			for (int i=1; i<ingredients.size(); i++) {
				pairingsList = pairingRepository.findByIngredient1Id(ingredients.get(i).getId());
				pairingsList.addAll(pairingRepository.findByIngredient2Id(ingredients.get(i).getId()));
				for (Pairing pairing : pairingsList) {
					if (pairing.getIngredient2().getName().matches(ingredientToCheck.getName())) {
						tempRatio *= pairing.getRel();
					}
				}
			}
			if (!checkIfContains(ingredients, ingredientToCheck) && !checkIfContains(notliked, ingredientToCheck)) {
				checkedIngredients += ingredientToCheck.getName()+", ";
				if (tempRatio > newRatio) {
					newRatio = tempRatio;
					matchingIngredient = ingredientToCheck;
				}
			}
		}
		
		Double currentRatio = getCombinationRatio(ingredients);
		String names = "";
		for (Ingredient ingredient : ingredients) {
			names += ingredient.getName()+", ";
		}

		
		return matchingIngredient;
	}
	
	private Boolean checkIfContains(List<Ingredient> list, Ingredient ingredientToCheck) {
		for (Ingredient ingredient : list) {
			if (ingredient.getId() == ingredientToCheck.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
}
