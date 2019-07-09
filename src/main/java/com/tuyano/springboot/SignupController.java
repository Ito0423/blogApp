package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


@Controller
public class SignupController {
	
@GetMapping("/login")
public String getLogin(Model model) {
	return ("login");
}
@GetMapping("/signup")
public String getSignUp(@ModelAttribute SignupForm form , Model model) {
	return"signup";
}
@PostMapping("/signup")
public String postSginUp(@ModelAttribute @Validated SignupForm form, 
		BindingResult bindingResult ,Model model) {
	if(bindingResult.hasErrors()) {
		return getSignUp(form,model);
	}
	System.out.println(form);
	return "redirect:/login";
}
}
