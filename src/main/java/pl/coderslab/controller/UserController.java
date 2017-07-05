package pl.coderslab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	SmartValidator validator;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path="/", method= RequestMethod.GET)
	public String mainUserPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("path","/user");
		return "mainUserView";
	}
	
	@RequestMapping(path="/register", method= RequestMethod.GET)
	public String registerUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("path","/user");
		return "registerForm";
	}
	
	@RequestMapping(path="/register", method= RequestMethod.POST)
	public String processRegisterUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("path","/user");
			return "registerForm";
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return "redirect:/user/login";
		}
	}
	
	// połącz login i register form potem
	@RequestMapping(path="/login", method= RequestMethod.GET)
	public String loginUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("path","/user");
		return "loginForm";
	}
	
	@RequestMapping(path="/login", method= RequestMethod.POST)
	public String processloginUser(@ModelAttribute User user, BindingResult result, Model model, HttpServletRequest request) {
		User userToCheck = userRepository.findByLogin(user.getLogin());
		if (userToCheck != null && passwordEncoder.matches(user.getPassword(), userToCheck.getPassword())) {
			request.getSession().setAttribute("logUserId", userToCheck.getId());
			request.getSession().setAttribute("logUserLogin", userToCheck.getLogin());
			return "redirect:/user/";
		} else {
			request.getSession().removeAttribute("logUserId");
			return "loginFailed";
		}
	}
	
	//logowanie przenieść do metody w pakiecie pl.coderslab.util -> class SecurityUtil
	@RequestMapping(path="/authenticated", method= RequestMethod.GET)	// z tego możemy iść w getTweets dla konkretnego użytkownika tweetRepo.getTweetByUserId(request.getSession().getAttribute("userId"))
	@ResponseBody
	public String isAuthenticated(Model model, HttpServletRequest request) {  //@SessionAttribute Long UserId
		String result = (String) request.getSession().getAttribute("logUserId");  //is Null ??
		
		if (result != null) {
			return userRepository.getOne(Long.valueOf(result)).getLogin();
		} else {
			return "Nie zalogowano.";
		}
		//Optional<T>.ofNullable(session.getAttribute("userId")).map(Object)
	}
	
	@RequestMapping(path="/logout", method= RequestMethod.GET)	
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
//	response.getWriter().append(request.getRemoteAddr()+"\n");  			// Adres IP
//	response.getWriter().append(request.getHeader("user-agent")+"\n");	// Przeglądarkę
//	response.getWriter().append(new Date().toString()+"\n");				// Aktualny czas

	
	//ADD
	@RequestMapping(path="/add", method= RequestMethod.GET)
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("path","/user");
		return "userForm";
	}
	
	@RequestMapping(path="/add", method= RequestMethod.POST)
	public String processAddUserForm(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("path","/user");
			return "userForm";
		} else {
			userRepository.save(user);
			return "redirect:/user/list";
		}
	}
	
	// LIST
	@RequestMapping(path="/list", method= RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "userList";
	}

	
	// EDIT
	@RequestMapping(path="/edit/{id}", method= RequestMethod.GET)
	public String editUser(Model model, @PathVariable Long id) {
		model.addAttribute("user", userRepository.findOne(id));
		model.addAttribute("path","");
		return "userForm";
	}
	
	@RequestMapping(path="/edit/{id}", method= RequestMethod.POST)
	public String processEditUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("path","/user");
			return "userForm";
		} else {
			userRepository.save(user);
			return "redirect:/user/list";
		}
	}
	
	
	// DELETE
	@RequestMapping(path="/delete/{id}", method= RequestMethod.GET)
	public String removeUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findOne(id));
		return "confirmRemove";
	}

	@RequestMapping(path="/delete/{id}", method= RequestMethod.POST)
	public String processRemoveBooks(@ModelAttribute User user) {
	
		userRepository.delete(user.getId());
		return "redirect:/user/list";
	}
}
