package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.Client;
import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.service.ClientService;
import com.localweb.thelogin.thelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
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

	@GetMapping("/update")
	public String update(@RequestParam("clientId") int id, Model model){
		Client client = clientService.getClient(id);
		model.addAttribute("client", client);
		return "client/client-update-form";
	}

	@PostMapping("/updateClient")
	public String updateClient(@RequestParam HashMap<String, String> data){
		System.out.println(data);
		Client client = clientService.getClient(Integer.parseInt(data.get("id")));
		if(client != null){
			client.setFirstName(data.get("firstName"));
			client.setLastName(data.get("lastName"));
			client.setEmail(data.get("email"));
			client.setDateUpdated(LocalDate.now());
			clientService.save(client);
		}
		return "redirect:/clients/";
	}
	
}
