package com.example.oneClick.controllers;

import com.example.oneClick.models.Person;
import com.example.oneClick.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/person_page/{id}")
    public String personPage(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.getPerson(id));
        return "user/personPage"; }


    @GetMapping("/person_edit_page/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.getPerson(id));
        return "user/personEditPage";
    }

    @PatchMapping("/person_edit_page/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personService.update(id, person);
        return "redirect:/person_page/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/catalog/catalog";
    }
}
