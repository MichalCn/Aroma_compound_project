package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.dao.PairingDao;
import pl.coderslab.model.Combination;
import pl.coderslab.model.Ingredient;
import pl.coderslab.model.Pairing;
import pl.coderslab.model.User;
import pl.coderslab.repository.IngredientRepository;
import pl.coderslab.repository.PairingRepository;
import pl.coderslab.services.RecipeGenerator;

@Controller
@RequestMapping("/pairing")
public class PairingController {

	@Autowired
	private PairingRepository pairingRepository;
	
	@Autowired
	private PairingDao pairingDao;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	SmartValidator validator;
	
	@Autowired
	RecipeGenerator recipeGenerator;
	
	@ModelAttribute("ingredients")		
	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}
	
	//FIND PAIRING
	@RequestMapping(path="/getPairing", method= RequestMethod.GET)
	@ResponseBody
	public String getPairing(Model model) {

		Ingredient ingredient = ingredientRepository.findOne(1L);
		Ingredient ingredientToCompare = ingredientRepository.findOne(2L);

		Pairing pairing = pairingRepository.findFirstByIngredient1IdAndIngredient2Id(ingredient.getId(), ingredientToCompare.getId());
		if (pairing == null) {
			pairing = pairingRepository.findFirstByIngredient1IdAndIngredient2Id(ingredientToCompare.getId(), ingredient.getId());
		}
		return "Pairing power: "+pairing.getRel();
	}
	
	
	//GET RATIO
	@RequestMapping(path="/ratio", method= RequestMethod.GET)
	@ResponseBody
	public String getRatio(Model model) {
		
		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(ingredientRepository.findOne(1L));
		ingredients.add(ingredientRepository.findOne(2L));
		ingredients.add(ingredientRepository.findOne(3L));
		ingredients.add(ingredientRepository.findOne(4L));
		
		return "Ratio: "+recipeGenerator.getCombinationRatio(ingredients);
	}	
	
	//ADD THROUGH FORM AND REPOSITORY
	@RequestMapping(path="/add", method= RequestMethod.GET)
	public String showAddPairingForm(Model model) {
		Pairing pairing = new Pairing();
		model.addAttribute("pairing", pairing);
		model.addAttribute("path","/pairing");
		return "pairingForm";
	}
	
	@RequestMapping(path="/add", method= RequestMethod.POST)
	public String processAddPairingForm(@Valid @ModelAttribute Pairing pairing, BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("path","/pairing");
			return "pairingForm";
		} else {
			pairingRepository.save(pairing);
			System.out.println("Pairing added to database");
			System.out.println(pairing);
			return "redirect:/";
		}
	}
	
	// GET=ADD=LOAD INGREDIENT THROUGH API
	@RequestMapping(path="/get", method= RequestMethod.GET)
	public String addPairing() {
		return "getPairingForm";
	}
	
	@RequestMapping(path="/get", method= RequestMethod.POST)
	@ResponseBody
	public String processAddPairing(@RequestParam String name) {
		Pairing pairing = pairingDao.getPairingFromApi(name);
		
		Ingredient ingFromDatabase = ingredientRepository.findFirstByName(pairing.getIngredient1().getName());
		if (ingFromDatabase != null) {
			pairing.setIngredient1(ingFromDatabase);
		} else {
			ingredientRepository.save(pairing.getIngredient1());
		}
		
		Ingredient ingFromDatabase2 = ingredientRepository.findFirstByName(pairing.getIngredient2().getName());
		if (ingFromDatabase2 != null) {
			pairing.setIngredient1(ingFromDatabase2);
		} else {
			ingredientRepository.save(pairing.getIngredient2());
		}
		
		pairingRepository.save(pairing);
		return "Success! Pairing added, id: "+pairing.getId();
	}
	
	// ADD=LOAD PAIRING THROUGH JSON FROM EXTERNAL SOURCE
	@RequestMapping(path="/load", method= RequestMethod.POST)	// not controller! move!!!
	@ResponseBody
	public String addPairingExternalJson(@RequestBody Pairing pairing){
		pairingRepository.save(pairing);
		return "Success! Pairing added, id: "+pairing.getId();
	}
	
}
