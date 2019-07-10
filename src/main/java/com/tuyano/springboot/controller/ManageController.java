package com.tuyano.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageController {

	
	@GetMapping("/manage")
	public String getHome(Model model) {
		
		return"Manage";
	}
	@PostMapping("/logout")
	 public	String postLogout() {
			return "redirect:/login";
	}
}