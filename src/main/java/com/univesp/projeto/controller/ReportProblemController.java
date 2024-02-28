package com.univesp.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportProblemController {
    @GetMapping({"/report-problem","/report-problem.html"})
    public String showIndex(ModelMap model){
        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");

        return "report-problem";
    }
}
