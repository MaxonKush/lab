package com.example.demo.controllers;


import com.example.demo.models.Auto;
import com.example.demo.models.Client;
import com.example.demo.models.Service;
import com.example.demo.models.User;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
//@RequestMapping("/auto")
@PreAuthorize("hasAuthority('USER')")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/client/edit/{id}")
    public String clientList(@PathVariable(value = "id") long id, Model model){

        if(!clientRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Client> client = clientRepository.findById(id);
        ArrayList<Client> res = new ArrayList<>();
        client.ifPresent(res::add);
        model.addAttribute("client", res);
        model.addAttribute("user", userRepository.findAll());
        return "clientEdit";
    }

    @PostMapping("/client/edit/{id}")
    public String clientSave(@PathVariable(value = "id") long id,
                              @RequestParam long id_user_id,
                              @RequestParam String first_name,
                              @RequestParam String second_name,
                              @RequestParam String patronymic,
                              @RequestParam String phone,
                              @RequestParam String address,
                              @RequestParam String driver_license,
                              @RequestParam String email,
                              @RequestParam String series,
                              @RequestParam String pass_number,
                              @RequestParam int experience, Model model){

        Client client = clientRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Client not found"));

        client.setId_user_id(id_user_id);
        client.setFirst_name(first_name);
        client.setSecond_name(second_name);
        client.setPatronymic(patronymic);
        client.setPhone(phone);
        client.setAddress(address);
        client.setDriver_license(driver_license);
        client.setEmail(email);
        client.setSeries(series);
        client.setPass_number(pass_number);
        client.setExperience(experience);

        clientRepository.save(client);
        return "redirect:/";
    }
}
