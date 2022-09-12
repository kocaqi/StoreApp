package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.Client;
import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientService clientService;

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
	public String saveUser(@ModelAttribute("client") Client client,
						   @AuthenticationPrincipal User user) {
		client.setDateCreated(LocalDate.now());
		client.setDateUpdated(LocalDate.now());
		client.setTheUser(user);
		clientService.save(client);
		return "redirect:/clients/";
	}
	
}
