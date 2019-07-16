package com.tuyano.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tuyano.springboot.data.UserData;
import com.tuyano.springboot.form.SignupForm;
import com.tuyano.springboot.repositories.UserDataRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


@Controller
public class SignupController {
	
	@Autowired 
	UserDataRepository repository;
	
@GetMapping("/signup")
public String getSignUp(@ModelAttribute SignupForm form , Model model) {
	return"signup";
}
@PostMapping("/signup")
public String postSginUp(@ModelAttribute @Validated SignupForm form, 
		BindingResult bindingResult ,Model model,UserData userdata) {
	if(bindingResult.hasErrors()) {
		return getSignUp(form,model);
	}
	
	System.out.println(form);
    repository.saveAndFlush(userdata);
    System.out.println("ooooo");
	return "redirect:/login";
}
}
