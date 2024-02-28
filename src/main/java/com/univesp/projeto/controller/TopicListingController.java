package com.univesp.projeto.controller;

import com.univesp.projeto.model.Hole;
import com.univesp.projeto.repository.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class TopicListingController {
    @Autowired
    DatabaseService db;

    @GetMapping({"/topics-listing","/topics-listing.html"})
    public String showTopicListing(ModelMap model){
        Date date = new Date();
        Hole teste = new Hole(2,"tes",date,"-20.45","-24.15","Nada",false,1);
        db.addHole(teste);
        List<Hole> items = db.getHoles();

        System.out.println(items);

        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");
        model.addAttribute("items",items);


        return "topics-listing";
    }
}
