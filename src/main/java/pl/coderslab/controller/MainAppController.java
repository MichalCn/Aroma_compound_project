package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class MainAppController {
		
	// ADD
	@RequestMapping(path="/", method= RequestMethod.GET)
	public String showAddAuthorForm() {
		return "mainAppView";
	}

}
