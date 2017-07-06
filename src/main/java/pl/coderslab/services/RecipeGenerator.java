package pl.coderslab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.Combination;
import pl.coderslab.model.Ingredient;
import pl.coderslab.model.Pairing;
import pl.coderslab.repository.PairingRepository;

@Service
public class RecipeGenerator {
	
	
	PairingRepository pairingRepository;
	
	public void init() {
		System.out.println("\n--------> 1\n");
		
	}
	
	@Autowired
	public void setPairingRepository(PairingRepository pairingRepository) {
		System.out.println("\n--------> 2\n " +(pairingRepository!=null));
		this.pairingRepository = pairingRepository;
	}
	
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
	
	private Ingredient getMatchingIngredient(List<Ingredient> ingredients) {
		
		Double currentRatio = getCombinationRatio(ingredients);
		
		Ingredient matchingIngredient = null;
		Double newRatio = 1.0;
		for (Ingredient ingredientToVerify : ingredients) {
		
		}
		
		return matchingIngredient;
	}
	
	private Combination matchIngredient(List<Ingredient> ingredients) {
		return null;
	}
	
	private Combination matchIngredientOfCategory (List<Ingredient> ingredients) {
		return null;
	}
	
	
}
