package com.jim.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jim on 26-11-17.
 */
@Controller
public class RegistratieController {

    @GetMapping("/registratie")
    public String registratiePagina(Model model){
        return "registratie";
    }

}
