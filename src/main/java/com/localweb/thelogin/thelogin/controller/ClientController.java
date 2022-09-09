package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.dao.ClientRepository;
import com.localweb.thelogin.thelogin.entities.Client;
import com.localweb.thelogin.thelogin.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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
	ClientRepository clientRepository;

	@GetMapping("/")
	public String showClients(Model model) {

		List<Client> clients = clientRepository.findAll();
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
	public String saveUser(@ModelAttribute("client") Client client) {
		client.setDateCreated(LocalDate.now());
		client.setDateUpdated(LocalDate.now());
		clientRepository.save(client);
		return "redirect:/clients/";
	}
	
}
