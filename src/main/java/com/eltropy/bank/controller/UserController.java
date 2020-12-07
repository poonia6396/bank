package com.eltropy.bank.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.eltropy.bank.entity.User;

@Controller
public class UserController {
   


    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    @PostMapping("/logout")
    public String logout(@ModelAttribute("logoutForm") User logoutForm, BindingResult bindingResult) {
    	System.out.println("logout requested");
        return "redirect:/login";
    }
    
}