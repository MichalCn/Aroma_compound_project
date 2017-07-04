package pl.coderslab.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.model.Combination;
import pl.coderslab.model.Ingredient;
import pl.coderslab.model.User;
import pl.coderslab.repository.CombinationRepository;
import pl.coderslab.repository.IngredientRepository;
import pl.coderslab.repository.UserRepository;


@Controller
@RequestMapping("/combination")
public class CombinationController {
	
	@Autowired
	private CombinationRepository combinationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@ModelAttribute("users")		
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@ModelAttribute("ingredients")		
	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}
	
	@Autowired
	SmartValidator validator;
	
	//ADD
	@RequestMapping(path="/add", method= RequestMethod.GET)
	public String showAddCombinationForm(Model model) {
		Combination combination = new Combination();
		model.addAttribute("combination", combination);
		model.addAttribute("path","/combination");
		return "combinationForm";
	}
	
	@RequestMapping(path="/add", method= RequestMethod.POST)
	public String processAddCombinationForm(@Valid @ModelAttribute Combination combination, BindingResult result, 
			Model model, @SessionAttribute Long logUserId) {
		if (result.hasErrors()) {
			model.addAttribute("path","/combination");
			return "combinationForm";
		} else {
			User user = userRepository.findOne(logUserId);
			combination.setUser(user);
			combinationRepository.save(combination);
			System.out.println(combination);
			return "redirect:/";
		}
	}

	// TEST QUERIES
	@RequestMapping(path="/test", method= RequestMethod.GET)
	@ResponseBody
	public String showQueries(Model model) {
		List<Combination> combinations = combinationRepository.findByUserId(Long.valueOf(1));
		return combinations.toString();
	}
}
