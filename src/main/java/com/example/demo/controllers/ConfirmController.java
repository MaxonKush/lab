package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repository.*;
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
@PreAuthorize("hasAuthority('USER')")
public class ConfirmController {

    @Autowired
    AutoRepository autoRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConfirmRepository confirmRepository;

    @GetMapping("/catalog/confirm/{id}")
    public String serviceAdd(@PathVariable(value = "id") long id, Model model){

        if(!autoRepository.existsById(id)){
            return "redirect:/catalog";
        }

        /*Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);*/

        Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> res = new ArrayList<>();
        auto.ifPresent(res::add);

        /*Optional<Client> clients = clientRepository.findById(id);
        ArrayList<Client> result = new ArrayList<>();
        clients.ifPresent(result::add);*/

        /*Optional<User> user = userRepository.findById(id);
        ArrayList<User> result_users = new ArrayList<>();
        user.ifPresent(result_users::add);*/

        Optional<Confirm> confirms = confirmRepository.findById(id);
        ArrayList<Confirm> result_confirms = new ArrayList<>();
        confirms.ifPresent(result_confirms::add);

        Iterable<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("auto", res);
        /*model.addAttribute("clients", result);
        model.addAttribute("user", result_users);*/
        model.addAttribute("confirms", result_confirms);
        model.addAttribute("client", clientRepository.findAll());

        return "confirm";
    }

    @PostMapping("/catalog/confirm/{id}")
    public String confirmAdd(@PathVariable(value = "id") long id,
                                 @RequestParam Long id_auto_id,
                                 @RequestParam Long id_client_id,
                                 @RequestParam String first_name,
                                 @RequestParam String second_name,
                                 @RequestParam String patronymic,
                                 @RequestParam String phone,
                                 @RequestParam String driver_license,
                                 @RequestParam String email,
                                 @RequestParam String series,
                                 @RequestParam String pass_number,
                                 @RequestParam String brand,
                                 @RequestParam String model,
                                 @RequestParam String number,
                                 @RequestParam int experience,
                                 Model models){

        Confirm confirm = new Confirm(id_auto_id, id_client_id, first_name, second_name, patronymic,
                phone, driver_license, email, series, pass_number, brand, model, number, experience );

        Auto autos = autoRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));
        autos.setState(0);

        confirmRepository.save(confirm);

        return "redirect:/catalog";
    }
}
