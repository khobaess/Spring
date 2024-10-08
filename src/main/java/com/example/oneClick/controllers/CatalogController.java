package com.example.oneClick.controllers;

import com.example.oneClick.models.*;
import com.example.oneClick.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class CatalogController {

    private final ChampagneService champagneService;
    private final EnergeticService energeticService;
    private final LowAlcoholService lowAlcoholService;
    private final StrongAlcoholService strongAlcoholService;
    private final WineService wineService;


    @Autowired
    public CatalogController(ChampagneService champagneService, EnergeticService energeticService, LowAlcoholService lowAlcoholService, StrongAlcoholService strongAlcoholService, WineService wineService) {
        this.champagneService = champagneService;
        this.energeticService = energeticService;
        this.lowAlcoholService = lowAlcoholService;
        this.strongAlcoholService = strongAlcoholService;
        this.wineService = wineService;
    }

    @GetMapping("/catalog")
    public String catalog() {
        return "/catalog/catalog";
    }

    //champagne
    @GetMapping("/champagnes")
    public String champagnes(Model model) {
        model.addAttribute("champagnes", champagneService.getChampagnes());
        return "champagne/champagnes";
    }

    @GetMapping("/champagne/{id}")
    public String champagne(@PathVariable("id") int id, Model model) {
        model.addAttribute("champagnes", champagneService.getChampagne(id));
        return "champagne/champagne";
    }

    @GetMapping("/champagne_edit")
    public String edit(@ModelAttribute("champagne") Champagne champagne, Model model) {
        model.addAttribute("product", champagneService.getChampagnes());
        return "champagne/champagneEditor";
    }

    @PatchMapping("/champagne/{id}")
    public String updateChampagne(@Valid @ModelAttribute("champagne") Champagne champagne, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", champagneService.getChampagnes());
            return "champagne/champagneEditor";
        }
        champagneService.update(champagne.getId(), champagne);
        return "redirect:/champagne/" + champagne.getId();
    }

    @PostMapping("/champagne_create")
    public String saveChampagne(@Valid @ModelAttribute("champagne") Champagne champagne, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", champagneService.getChampagnes());
            return "champagne/champagneEditor";
        }
        champagneService.save(champagne);
        return "redirect:/champagne/" + champagne.getId();
    }

    @DeleteMapping("/champagne_delete/{id}")
    public String deleteChampagne(@PathVariable("id") int id) {
        champagneService.delete(id);
        return "redirect:/champagne_edit";
    }


    //energetic
    @GetMapping("/energetics")
    public String energetics(Model model) {
        model.addAttribute("energetics", energeticService.getEnergetics());
        return "energetic/energetics";
    }

    @GetMapping("/energetic/{id}")
    public String energetic(@PathVariable("id") int id, Model model) {
        model.addAttribute("energetics", energeticService.getEnergetic(id));
        return "energetic/energetic";
    }

    @GetMapping("/energetic_edit")
    public String edit(@ModelAttribute("energetic") Energetic energetic, Model model) {
        model.addAttribute("product", energeticService.getEnergetics());
        return "energetic/energeticEditor";
    }

    @PatchMapping("/energetic/{id}")
    public String updateEnergetic(@Valid @ModelAttribute("energetic") Energetic energetic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", energeticService.getEnergetics());
            return "energetic/energeticEditor";
        }
        energeticService.update(energetic.getId(), energetic);
        return "redirect:/energetic/" + energetic.getId();
    }

    @PostMapping("/energetic_create")
    public String saveEnergetic(@Valid @ModelAttribute("energetic") Energetic energetic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", energeticService.getEnergetics());
            return "energetic/energeticEditor";
        }
        energeticService.save(energetic);
        return "redirect:/energetic/" + energetic.getId();
    }

    @DeleteMapping("/energetic_delete/{id}")
    public String deleteEnergetic(@PathVariable("id") int id) {
        energeticService.delete(id);
        return "redirect:/energetic_edit";
    }


    //lowAlcohol
    @GetMapping("/lowAlcohols")
    public String lowAlcohols(Model model) {
        model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohols());
        return "lowAlcohol/lowAlcohols";
    }

    @GetMapping("/lowAlcohol/{id}")
    public String lowAlcohol(@PathVariable("id") int id, Model model) {
        model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohol(id));
        return "lowAlcohol/lowAlcohol";
    }

    @GetMapping("/lowAlcohol_edit")
    public String edit(@ModelAttribute("lowAlcohol") LowAlcohol lowAlcohol, Model model) {
        model.addAttribute("product", lowAlcoholService.getLowAlcohols());
        return "lowAlcohol/lowAlcoholEditor";
    }

    @PatchMapping("/lowAlcohol/{id}")
    public String updateLowAlcohol(@Valid @ModelAttribute("lowAlcohol") LowAlcohol lowAlcohol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", lowAlcoholService.getLowAlcohols());
            return "lowAlcohol/lowAlcoholEditor";
        }
        lowAlcoholService.update(lowAlcohol.getId(), lowAlcohol);
        return "redirect:/lowAlcohol/" + lowAlcohol.getId();
    }

    @PostMapping("/lowAlcohol_create")
    public String saveLowAlcohol(@Valid @ModelAttribute("lowAlcohol") LowAlcohol lowAlcohol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", lowAlcoholService.getLowAlcohols());
            return "lowAlcohol/lowAlcoholEditor";
        }
        lowAlcoholService.save(lowAlcohol);
        return "redirect:/lowAlcohol/" + lowAlcohol.getId();
    }

    @DeleteMapping("/lowAlcohol_delete/{id}")
    public String deleteLowAlcohol(@PathVariable("id") int id) {
        lowAlcoholService.delete(id);
        return "redirect:/lowAlcohol_edit";
    }


    //strongAlcohol
    @GetMapping("/strongAlcohols")
    public String strongAlcohols(Model model) {
        model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohols());
        return "strongAlcohol/strongAlcohols";
    }

    @GetMapping("/strongAlcohol/{id}")
    public String strongAlcohol(@PathVariable("id") int id, Model model) {
        model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohol(id));
        return "strongAlcohol/strongAlcohol";
    }

    @GetMapping("/strongAlcohol_edit")
    public String edit(@ModelAttribute("strongAlcohol") StrongAlcohol strongAlcohol, Model model) {
        model.addAttribute("product", strongAlcoholService.getStrongAlcohols());
        return "strongAlcohol/strongAlcoholEditor";
    }

    @PatchMapping("/strongAlcohol/{id}")
    public String updateStrongAlcohol(@Valid @ModelAttribute("strongAlcohol") StrongAlcohol strongAlcohol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", strongAlcoholService.getStrongAlcohols());
            return "strongAlcohol/strongAlcoholEditor";
        }
        strongAlcoholService.update(strongAlcohol.getId(), strongAlcohol);
        return "redirect:/strongAlcohol/" + strongAlcohol.getId();
    }

    @PostMapping("/strongAlcohol_create")
    public String saveStrongAlcohol(@Valid @ModelAttribute("strongAlcohol") StrongAlcohol strongAlcohol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", strongAlcoholService.getStrongAlcohols());
            return "strongAlcohol/strongAlcoholEditor";
        }
        strongAlcoholService.save(strongAlcohol);
        return "redirect:/strongAlcohol/" + strongAlcohol.getId();
    }

    @DeleteMapping("/strongAlcohol_delete/{id}")
    public String deleteStrongAlcohol(@PathVariable("id") int id) {
        strongAlcoholService.delete(id);
        return "redirect:/strongAlcohol_edit";
    }


    //wine
    @GetMapping("/wines")
    public String wines(Model model) {
        model.addAttribute("wines", wineService.getWines());
        return "wine/wines";
    }

    @GetMapping("/wine/{id}")
    public String wine(@PathVariable("id") int id, Model model) {
        model.addAttribute("wines", wineService.getWine(id));
        return "wine/wine";
    }

    @GetMapping("/wine_edit")
    public String edit(@ModelAttribute("wine") Wine wine, Model model) {
        model.addAttribute("product", wineService.getWines());
        return "wine/wineEditor";
    }

    @PatchMapping("/wine/{id}")
    public String updateWine(@Valid @ModelAttribute("wine") Wine wine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", wineService.getWines());
            return "wine/wineEditor";
        }
        wineService.update(wine.getId(), wine);
        return "redirect:/wine/" + wine.getId();
    }

    @PostMapping("/wine_create")
    public String saveWine(@Valid @ModelAttribute("wine") Wine wine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", wineService.getWines());
            return "wine/wineEditor";
        }
        wineService.save(wine);
        return "redirect:/wine/" + wine.getId();
    }

    @DeleteMapping("/wine_delete/{id}")
    public String deleteWine(@PathVariable("id") int id) {
        wineService.delete(id);
        return "redirect:/wine_edit";
    }
}