package com.example.demo.controllers;


import com.example.demo.models.Auto;
import com.example.demo.models.Client;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(User user, Client client, Map<String, Object> model){

        User userFromDb = userRepository.findByUsername(user.getUsername());
        User userCheckEmail = userRepository.findByEmail(user.getEmail());

        if(userFromDb != null){
            model.put("errorUsername", "Пользователь с таким никнеймом уже существует!");
            return "register";
        }

        if(userCheckEmail != null){
            model.put("errorEmail", "Пользователь с такой почтой уже существует!");
            return "register";
        }

        user.setActive(1);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        client.setId_user_id(user.getId());
        clientRepository.save(client);


        return ("redirect:/login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
