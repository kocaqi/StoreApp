package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	@Autowired UserService userService;

	@GetMapping("/")
	public String showHome(Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		model.addAttribute("user", user);
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
}
