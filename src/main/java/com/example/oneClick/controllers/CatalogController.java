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
    public String catalog(){
        return "/catalog/catalog";
    }

    //champagne
    @GetMapping("/champagnes")
    public String champagnes(Model model){
        model.addAttribute("champagnes", champagneService.getChampagnes());
        return "champagne/champagnes";
    }
    @GetMapping("/champagne/{id}")
    public String champagne(@PathVariable("id") int id, Model model){
        model.addAttribute("champagnes", champagneService.getChampagne(id));
        return "champagne/champagne";
    }
    @GetMapping("/champagne_edit")
    public String editChampagne(@ModelAttribute("champagne") Champagne champagne, Model model) {
        model.addAttribute("champagnes", champagneService.getChampagnes());
        return "champagne/champagneEditor";
    }
    @PatchMapping("/champagne_edit/{id}")
    public String updateChampagne(@PathVariable("id") int id, @ModelAttribute @Valid Champagne champagne,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("champagnes", champagneService.getChampagnes()); // добавить список продуктов в модель
            return "champagne/champagneEditor";
        }
        try {
            champagneService.update(id, champagne);
            return "redirect:/champagnes";
        } catch (Exception e) {
            System.err.println("Error updating champagne: " + e.getMessage());
            e.printStackTrace();  // Вывести стек ошибки в логи
            result.reject("update.error", "Произошла ошибка при обновлении продукта.");
            model.addAttribute("champagnes", champagneService.getChampagnes());
            return "champagne/champagneEditor";
        }
    }
    @PostMapping("/saveChampagnes")
    public String saveChampagne(@Valid @ModelAttribute("champagne") Champagne champagne, BindingResult result) {
        if (result.hasErrors()) {
            return "champagne/champagneEditor";
        }
        champagneService.save(champagne);
        return "redirect:/champagnes";
    }
    @DeleteMapping("/champagne_delete/{id}")
    public String deleteChampagne(@PathVariable("id") int id) {
        champagneService.delete(id);
        return "redirect:/champagnes";
    }


    //energetic
    @GetMapping("/energetics")
    public String energetics(Model model){
        model.addAttribute("energetics", energeticService.getEnergetics());
        return "energetic/energetics";
    }
    @GetMapping("/energetic/{id}")
    public String energetic(@PathVariable("id") int id, Model model){
        model.addAttribute("energetics", energeticService.getEnergetic(id));
        return "energetic/energetic";
    }
    @GetMapping("/energetic_edit")
    public String editEnergetic(@ModelAttribute("en") Energetic energetic, Model model) {
        model.addAttribute("energetics", energeticService.getEnergetics());
        return "energetic/energeticEditor";
    }
    @PatchMapping("/energetic_edit/{id}")
    public String updateEnergetic(@PathVariable("id") int id, @ModelAttribute @Valid Energetic energetic,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("energetics", energeticService.getEnergetics()); // добавить список продуктов в модель
            return "redirect:/energetics";
        }
        try {
            energeticService.update(id, energetic);
            return "redirect:/energetics";
        } catch (Exception e) {
            System.err.println("Error updating energetic: " + e.getMessage());
            e.printStackTrace();  // Вывести стек ошибки в логи
            result.reject("update.error", "Произошла ошибка при обновлении продукта.");
            model.addAttribute("energetics", energeticService.getEnergetics());
            return "energetic/energeticEditor";
        }
    }
    @PostMapping("/saveEnergetics")
    public String saveEnergetic(@Valid @ModelAttribute("energetic") Energetic energetic, BindingResult result) {
        if (result.hasErrors()) {
            return "energetic/energeticEditor";
        }
        energeticService.save(energetic);
        return "redirect:/energetics";
    }
    @DeleteMapping("/energetic_delete/{id}")
    public String deleteEnergetic(@PathVariable("id") int id) {
        energeticService.delete(id);
        return "redirect:/products";
    }


    //lowAlcohol
    @GetMapping("/lowAlcohols")
    public String lowAlcohols(Model model){
        model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohols());
        return "lowAlcohol/lowAlcohols";
    }
    @GetMapping("/lowAlcohol/{id}")
    public String lowAlcohol(@PathVariable("id") int id, Model model){
        model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohol(id));
        return "lowAlcohol/lowAlcohol";
    }
    @GetMapping("/lowAlcohol_edit")
    public String editLowAlcohol(Model model) {
        model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohols());
        return "lowAlcohol/lowAlcoholEditor";
    }
    @PatchMapping("/lowAlcohol_edit/{id}")
    public String updateLowAlcohol(@PathVariable("id") int id, @ModelAttribute @Valid LowAlcohol lowAlcohol,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohols()); // добавить список продуктов в модель
            return "lowAlcohol/lowAlcoholEditor";
        }
        try {
            lowAlcoholService.update(id, lowAlcohol);
            return "redirect:/lowAlcohol";
        } catch (Exception e) {
            System.err.println("Error updating lowAlcohol: " + e.getMessage());
            e.printStackTrace();  // Вывести стек ошибки в логи
            result.reject("update.error", "Произошла ошибка при обновлении продукта.");
            model.addAttribute("lowAlcohols", lowAlcoholService.getLowAlcohols());
            return "lowAlcohol/lowAlcoholEditor";
        }
    }
    @PostMapping("/saveLowAlcohol")
    public String saveLowAlcohol(@Valid @ModelAttribute("lowAlcohol") LowAlcohol lowAlcohol, BindingResult result) {
        if (result.hasErrors()) {
            return "lowAlcohol/lowAlcoholEditor";
        }
        lowAlcoholService.save(lowAlcohol);
        return "redirect:/lowAlcohols";
    }
    @DeleteMapping("/lowAlcohol_delete/{id}")
    public String deleteLowAlcohol(@PathVariable("id") int id) {
        lowAlcoholService.delete(id);
        return "redirect:/lowAlcohols";
    }


    //strongAlcohol
    @GetMapping("/strongAlcohols")
    public String strongAlcohols(Model model){
        model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohols());
        return "strongAlcohol/strongAlcohols";
    }
    @GetMapping("/strongAlcohol/{id}")
    public String strongAlcohol(@PathVariable("id") int id, Model model){
        model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohol(id));
        return "strongAlcohol/strongAlcohol";
    }
    @GetMapping("/strongAlcohol_edit")
    public String editStrongAlcohol(Model model) {
        model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohols());
        return "strongAlcohol/strongAlcoholEditor";
    }
    @PatchMapping("/strongAlcohol_edit/{id}")
    public String updateStrongAlcohol(@PathVariable("id") int id, @ModelAttribute @Valid StrongAlcohol strongAlcohol,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohols()); // добавить список продуктов в модель
            return "strongAlcohol/strongAlcoholEditor";
        }
        try {
            strongAlcoholService.update(id, strongAlcohol);
            return "redirect:/strongAlcohols";
        } catch (Exception e) {
            System.err.println("Error updating strongAlcohol: " + e.getMessage());
            e.printStackTrace();  // Вывести стек ошибки в логи
            result.reject("update.error", "Произошла ошибка при обновлении продукта.");
            model.addAttribute("strongAlcohols", strongAlcoholService.getStrongAlcohols());
            return "strongAlcohol/strongAlcoholEditor";
        }
    }
    @PostMapping("/saveStrongAlcohol")
    public String saveStrongAlcohol(@Valid @ModelAttribute("strongAlcohol") StrongAlcohol strongAlcohol, BindingResult result) {
        if (result.hasErrors()) {
            return "energetic/energeticEditor";
        }
        strongAlcoholService.save(strongAlcohol);
        return "redirect:/energetics";
    }
    @DeleteMapping("/strongAlcohol_delete/{id}")
    public String deleteStrongAlcohol(@PathVariable("id") int id) {
        strongAlcoholService.delete(id);
        return "redirect:/strongAlcohols";
    }


    //wine
    @GetMapping("/wines")
    public String wines(Model model){
        model.addAttribute("wines", wineService.getWines());
        return "wine/wines";
    }
    @GetMapping("/wine/{id}")
    public String wine(@PathVariable("id") int id, Model model){
        model.addAttribute("wines", wineService.getWine(id));
        return "wine/wine";
    }
    @GetMapping("/wine_edit")
    public String editWine(Model model) {
        model.addAttribute("wines", wineService.getWines());
        return "wine/wineEditor";
    }
    @PatchMapping("/wine_edit/{id}")
    public String updateWine(@PathVariable("id") int id, @ModelAttribute @Valid Wine wine,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("wines", wineService.getWines()); // добавить список продуктов в модель
            return "wine/wineEditor";
        }
        try {
            wineService.update(id, wine);
            return "redirect:/wines";
        } catch (Exception e) {
            System.err.println("Error updating wine: " + e.getMessage());
            e.printStackTrace();  // Вывести стек ошибки в логи
            result.reject("update.error", "Произошла ошибка при обновлении продукта.");
            model.addAttribute("wines", wineService.getWines());
            return "wine/wineEditor";
        }
    }
    @PostMapping("/saveWine")
    public String saveWine(@Valid @ModelAttribute("wine") Wine wine, BindingResult result) {
        if (result.hasErrors()) {
            return "wine/wineEditor";
        }
        wineService.save(wine);
        return "redirect:/wines";
    }
    @DeleteMapping("/wine_delete/{id}")
    public String deleteWine(@PathVariable("id") int id) {
        wineService.delete(id);
        return "redirect:/wines";
    }

}
