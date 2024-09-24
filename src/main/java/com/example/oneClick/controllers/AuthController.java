package com.example.oneClick.controllers;

import com.example.oneClick.models.Person;
import com.example.oneClick.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("auth")
public class AuthController {

    private final PersonService personService;

    @Autowired
    public AuthController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String Auth(Model model){
        return "user/login";
    }

    @GetMapping("/registration")
    public String create(@ModelAttribute("person") Person person){
        return "user/registration";
    }

    @PostMapping("/registration")
    public String save(@Valid @ModelAttribute("person") Person person,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/registration";
        }
        personService.save(person);
        return "redirect:/catalog/catalog";
    }
}
