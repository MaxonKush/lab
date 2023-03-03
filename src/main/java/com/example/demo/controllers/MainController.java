package com.example.demo.controllers;

import com.example.demo.models.Auto;
import com.example.demo.models.Client;
import com.example.demo.models.User;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Auto> autos = autoRepository.findAll();
        model.addAttribute("autos", autos);

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Страница логина");
        return "login";
    }

}