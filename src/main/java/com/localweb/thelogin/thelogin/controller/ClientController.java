package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.Client;
import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.service.ClientService;
import com.localweb.thelogin.thelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String showClients(Model model) {

		List<Client> clients = clientService.findAll();
		model.addAttribute("clients", clients);

		return "client/clients";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "client/client-form";
	}

	@PostMapping("/saveClient")
	public String saveUser(@ModelAttribute("client") Client client, Principal principal) {
		client.setDateCreated(LocalDate.now());
		client.setDateUpdated(LocalDate.now());
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		client.setTheUser(user);
		clientService.save(client);
		return "redirect:/clients/";
	}
	
}
