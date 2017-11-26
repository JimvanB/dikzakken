package com.jim.spring.controller;

import com.jim.spring.command.DeelnemerCommand;
import com.jim.spring.domain.Deelnemer;
import com.jim.spring.service.DeelnemerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jim on 26-11-17.
 */
@Controller
public class RegistratieController {

    DeelnemerService deelnemerService;

    public RegistratieController(DeelnemerService deelnemerService) {
        this.deelnemerService = deelnemerService;
    }

    @PostMapping("/newuser")
    public String addUser(@Valid @ModelAttribute("user") DeelnemerCommand deelnemerCommand, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.toString());
            });
            return "registratieForm";
        }

        Deelnemer deelnemer = new Deelnemer(deelnemerCommand.getName());
        deelnemerService.saveDeelnemer(deelnemer);
        return "redirect:/";
    }

    @GetMapping("/registratie")
    public String registratiePagina(Model model) {
        model.addAttribute("user", new DeelnemerCommand());
        return "registratieForm";
    }

}
