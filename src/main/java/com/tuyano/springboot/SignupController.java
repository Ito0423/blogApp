package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignupController {
@GetMapping("/login")
public String getLogin(Model model) {
	return ("login");
}
@GetMapping("/signup")
public String getSignUp(Model model) {
	return"signup";
}
public String postSginUp(Model model) {
	return "login";
}
}
