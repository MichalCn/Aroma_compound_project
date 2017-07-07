package pl.coderslab.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
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
import pl.coderslab.services.RecipeGenerator;


@Controller
@RequestMapping("/combination")
public class CombinationController {
	
	@Autowired
	private CombinationRepository combinationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	RecipeGenerator generator;
	
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
	
	//CREATE NEW COMBINATION ULTIMATE
	@RequestMapping(path="/addultimate", method= RequestMethod.GET)
	public String showAddCombinationFormUltimate(Model model) {
		Combination combination = new Combination();
		model.addAttribute("combination", combination);
		return "combinationFormUltimate";
	}
	
	@RequestMapping(path="/addultimate", method= RequestMethod.POST)
	public String processAddCombinationFormUltimate(@Valid @ModelAttribute Combination combination, BindingResult result, 
			Model model, @SessionAttribute Long logUserId, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("path","/combination");
			return "combinationFormUltimate";
		} else {
			
			User user = userRepository.findOne(logUserId);
			combination.setUser(user);
			request.getSession().setAttribute("combination", combination);
			return "redirect:/combination/addultimatematching";
		}
	}
	
	@RequestMapping(path="/addultimatematching", method= RequestMethod.GET)
	public String showAddCombinationFormUltimateMore123(Model model, @SessionAttribute Combination combination,
			HttpServletRequest request) {
		List<Ingredient> notliked = new ArrayList<>();
		if (request.getSession().getAttribute("notliked") != null) {
			notliked = (List<Ingredient>) request.getSession().getAttribute("notliked");	// <--
		}
		List<Ingredient> ingredients;
		ingredients = combination.getIngredients();
		model.addAttribute("combings", ingredients);
		model.addAttribute("currentRatio", generator.getCombinationRatio(ingredients));
		Ingredient matchingIngredient = generator.getMatchingIngredient(ingredients, notliked);
		model.addAttribute("ingredient", matchingIngredient.getName());
		model.addAttribute("ingredientWhole", matchingIngredient);
		request.getSession().setAttribute("combination", combination);
		request.getSession().setAttribute("ingredient", matchingIngredient);
		return "combinationFormUltimateMore";
	}
	
	@RequestMapping(path="/nextmatch", method= RequestMethod.GET)
	public String showCombinationFormNextMatch(Model model, @SessionAttribute Combination combination, 
			@SessionAttribute Ingredient ingredient, HttpServletRequest request) {
		List<Ingredient> notliked = new ArrayList<>();
		if (request.getSession().getAttribute("notliked") != null) {
			notliked = (List<Ingredient>) request.getSession().getAttribute("notliked");	// <--
		}
		notliked.add(ingredient);
		request.getSession().setAttribute("notliked", notliked);
		return "redirect:/combination/addultimatematching";
	}
	
	@RequestMapping(path="/addmatch", method= RequestMethod.GET)
	public String showAddCombinationFormUltimateMore(Model model, @SessionAttribute Combination combination, 
			@SessionAttribute Ingredient ingredient, HttpServletRequest request) {
		List<Ingredient> ingredients = combination.getIngredients();
		ingredients.add(ingredient);
		combination.setIngredients(ingredients);
		request.getSession().setAttribute("combination", combination);
		return "redirect:/combination/addultimatematching";
	}
	
	@RequestMapping(path="/saveultimate", method= RequestMethod.GET)
	public String saveAddCombinationFormUltimateMore(Model model, @SessionAttribute Combination combination, 
			HttpServletRequest request) {
		combinationRepository.save(combination);
		request.getSession().removeAttribute("combination");
		request.getSession().removeAttribute("ingredient");
		request.getSession().removeAttribute("notliked");
		return "redirect:/combination/list";
	}
		
	//ADD
	@RequestMapping(path="/add", method= RequestMethod.GET)
	public String showAddCombinationForm(Model model) {
		Combination combination = new Combination();
		model.addAttribute("combination", combination);
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
	
	//LIST BY USER
	@RequestMapping(path="/list", method= RequestMethod.GET)
	public String showUserCombinations(Model model, @SessionAttribute(name="logUserId") Long id) {
		model.addAttribute("combinations", combinationRepository.findByUserId(id));
		return "combinationList";
	}
	
	//LIST ALL
	@RequestMapping(path="/listall", method= RequestMethod.GET)	// dodac wyswietlanie user id
	public String showAllCombinations(Model model) {
		model.addAttribute("combinations", combinationRepository.findAll());
		return "combinationList";
	}

}
