package com.localweb.thelogin.thelogin.controller;

import java.time.LocalDate;
import java.util.List;

import com.localweb.thelogin.thelogin.dao.RoleRepository;
import com.localweb.thelogin.thelogin.dao.UserRepository;
import com.localweb.thelogin.thelogin.entities.User;
import com.localweb.thelogin.thelogin.service.RoleService;
import com.localweb.thelogin.thelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public String showUsers(Model model) {

        List<User> users = userService.findAll();
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
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam("role") String role) {
        user.setDateCreated(LocalDate.now());
        user.setDateUpdated(LocalDate.now());
        user.setEnabled(1);
        user.addRole(roleService.findRoleByName(role));
        userService.save(user);
        return "redirect:/users/";
    }

}
