package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.IngredientDao;
import pl.coderslab.model.Ingredient;
import pl.coderslab.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private IngredientDao ingredientDao; 
	
	// TEST GET
	@RequestMapping(path="/testget", method= RequestMethod.GET)
	@ResponseBody
	public String getTestIngredient() {
		Ingredient ingredient = ingredientRepository.getOne(1L);
		return ingredient.getName();
	}
	
	// ADD=LOAD INGREDIENT THROUGH API
	@RequestMapping(path="/add", method= RequestMethod.GET)
	public String addIngredient() {
		return "getIngredientForm";
	}
	
	@RequestMapping(path="/add", method= RequestMethod.POST)
	@ResponseBody
	public String processAddIngredient(@RequestParam String name) {
		Ingredient ingredient = ingredientDao.getIngredientFromApi(name);
		ingredientRepository.save(ingredient);
		System.out.println(ingredient.getName());
		return "Success! Ingredient added, id: "+ingredient.getId();
	}
	
	// ADD=LOAD INGREDIENT THROUGH JSON FROM EXTERNAL SOURCE
	@RequestMapping(path="/load", method= RequestMethod.POST)
	@ResponseBody
	public String addIngredientExternajJson(@RequestBody Ingredient ingredient){
		ingredientRepository.save(ingredient);
		System.out.println(ingredient.getName());
		return "Success! Ingredient added, id: "+ingredient.getId();
	}
	
	
//	@RequestMapping(path="/add1", method= RequestMethod.GET)
//	public String addIngredient1() {
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Tomato");
//		ingredientRepository.save(ingredient);
//		return "redirect:/ingredient/add2";
//	}
//	
//	@RequestMapping(path="/add2", method= RequestMethod.GET)
//	public String addIngredient2() {
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Pinaple");
//		ingredientRepository.save(ingredient);
//		return "redirect:/ingredient/add3";
//	}
//	
//	@RequestMapping(path="/add3", method= RequestMethod.GET)
//	public String addIngredient3() {
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Potato");
//		ingredientRepository.save(ingredient);
//		return "redirect:/ingredient/add4";
//	}
//	
//	@RequestMapping(path="/add4", method= RequestMethod.GET)
//	public String addIngredient4() {
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Veal");
//		ingredientRepository.save(ingredient);
//		return "redirect:/ingredient/add5";
//	}
//	
//	@RequestMapping(path="/add5", method= RequestMethod.GET)
//	@ResponseBody
//	public String addIngredient5() {
//		Ingredient ingredient = new Ingredient();
//		ingredient.setName("Hazelnut");
//		ingredientRepository.save(ingredient);
//		return "ingredients generated";
//	}
	
}
