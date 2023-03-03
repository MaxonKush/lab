package com.example.demo.controllers;

import com.example.demo.models.Auto;
import com.example.demo.models.Client;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ClientRepository clientRepository;

    //@GetMapping("/user")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    //@GetMapping("/user/{id}")
    public String userSingle(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "usersingle";
    }

    //@PostMapping("/user/{id}")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam String first_name,
            @RequestParam String second_name,
            @RequestParam String email,
            @RequestParam int active,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){

        user.setUsername(username);
        user.setFirst_name(first_name);
        user.setSecond_name(second_name);
        user.setEmail(email);
        user.setActive(active);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }

    @PostMapping("/{id}/remove")
    public String userDelete(@PathVariable(value = "id") long id, Model models){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        userRepository.delete(user);
        return "redirect:/user";
    }


    @GetMapping("/add")
    public String staffAdd(){
        return "staffAdd";
    }

    @PostMapping("/add")
    public String staffUser(User users, Map<String, Object> model){

        User userFromDb = userRepository.findByUsername(users.getUsername());
        User userCheckEmail = userRepository.findByEmail(users.getEmail());

        if(userFromDb != null){
            model.put("errorUsername", "Пользователь с таким никнеймом уже существует!");
            return "staffAdd";
        }

        if(userCheckEmail != null){
            model.put("errorEmail", "Пользователь с такой почтой уже существует!");
            return "staffAdd";
        }

        users.setActive(1);
        users.setRoles(Collections.singleton(Role.STAFF));
        userRepository.save(users);

        return ("redirect:/user");
    }

    @GetMapping("/client/list")
    public String clientList(Model model){
        model.addAttribute("client", clientRepository.findAll());
        return "clientList";
    }
    @PostMapping("/client/{id_user_id}/remove")
    public String clientDelete(@PathVariable(value = "id_user_id") long id_user_id, Model models){
        User user = userRepository.findById(id_user_id).orElseThrow(() -> new UsernameNotFoundException("Client not found"));

        userRepository.delete(user);
        return "redirect:/user";
    }
}
