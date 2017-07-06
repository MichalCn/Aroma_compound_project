package pl.coderslab.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.Combination;
import pl.coderslab.model.Ingredient;
import pl.coderslab.model.Pairing;
import pl.coderslab.repository.PairingRepository;

@Service
public class RecipeGenerator {
	
	@Autowired
	PairingRepository pairingRepository;
	
	public Double getCombinationRatio(List<Ingredient> ingredients) {
		Double ratio = 1.0;
		int counter = 0;
		
		List<Ingredient> ingredientsToCompare = ingredients;
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
	
	public Ingredient getMatchingIngredient(List<Ingredient> ingredients) {
		
		List<Pairing> pairingsListMain = new ArrayList<>();
		
		pairingsListMain = pairingRepository.findByIngredient1Id(ingredients.get(0).getId());
		for (int i =0; i < pairingsListMain.size(); i++) {
			for (Ingredient ingredient : ingredients) {
				if (ingredient.getId() == pairingsListMain.get(i).getIngredient2().getId()) {
					pairingsListMain.remove(i);
				}
			}
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
//				pairingsList.addAll(pairingRepository.findByIngredient2Id(ingredient.getId()));	//jesli nie wszystkie pairingsy dwustronne w bazie
				for (Pairing pairing : pairingsList) {
					if (pairing.getIngredient2().getName().matches(ingredientToCheck.getName())) {
						tempRatio *= pairing.getRel();
					}
				}
				
			}

			if (!ingredients.contains(ingredientToCheck)) {
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
		
		System.out.println("Initial ingredients: "+names);
		System.out.println("Checked ingredients: "+checkedIngredients);
		System.out.println("Matching ingredient: "+matchingIngredient.getName());
		System.out.println("Best ratio: "+newRatio);
		System.out.println("Final new ratio: "+currentRatio*newRatio);
		
		return matchingIngredient;
	}
	
	
	
	
	
	private Combination matchIngredient(List<Ingredient> ingredients) {
		return null;
	}
	
	private Combination matchIngredientOfCategory (List<Ingredient> ingredients) {
		return null;
	}
	
	
}
