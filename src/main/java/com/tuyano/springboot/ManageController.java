package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageController {

	
	@GetMapping("/manage")
	public String getHome(Model model) {
		model.addAttribute("content","login/home::home_contents");
		
		return"login/homelayout";
	}
	@PostMapping("/logout")
	 public	String postLogout() {
			return "redirect:/login";
	}
}