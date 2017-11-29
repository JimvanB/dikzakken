package com.jim.spring.controller;

import com.jim.spring.command.UserCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jim on 29-11-17.
 */
@Controller
public class LoginController {

    @GetMapping("/loginForm")
    public String login(Model model){
        model.addAttribute("user", new UserCommand());
        return "loginForm";
    }


}
