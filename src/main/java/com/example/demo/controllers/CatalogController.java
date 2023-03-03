package com.example.demo.controllers;

import com.example.demo.models.Auto;
import com.example.demo.models.Client;
import com.example.demo.models.Confirm;
import com.example.demo.models.User;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ConfirmRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CatalogController {

    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<Auto> autos = autoRepository.findAll();
        model.addAttribute("autos", autos);

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "catalog";
    }
    @GetMapping("/catalog/{id}")
    public String carsingle(@PathVariable(value = "id") long id, Model model) {

        if(!autoRepository.existsById(id)){
            return "redirect:/catalog";
        }

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);

        Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> res = new ArrayList<>();
        auto.ifPresent(res::add);
        model.addAttribute("auto", res);
        return "carsingle";
    }

}