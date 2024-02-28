package com.univesp.projeto.controller;
import com.univesp.projeto.model.Hole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping({"/contact","/contact.html"})
    public String showContact(ModelMap model){
        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");
        
        return "contact";
    }
}
