package com.localweb.thelogin.thelogin.controller;

import java.time.LocalDate;
import java.util.List;

import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showUsers(Model model) {

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        user.setDateCreated(LocalDate.now());
        user.setDateUpdated(LocalDate.now());
        user.setEnabled(1);
        userRepository.save(user);
        return "redirect:/users/";
    }

}
