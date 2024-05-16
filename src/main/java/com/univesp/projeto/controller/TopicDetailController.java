package com.univesp.projeto.controller;
import com.univesp.projeto.model.Hole;
import com.univesp.projeto.repository.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicDetailController {
    @Autowired
    DatabaseService db;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/img";


    @GetMapping({"/topics-detail","/topics-detail.html"})
    public String showTopicDetail(ModelMap model){
        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");

        return "topics-detail.html";
    }

    @GetMapping("/topics-detail/{id}")
    public String showDetailById(@PathVariable("id") Long id,  ModelMap model){
        Hole item = db.getHoleById(id);
        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");
        model.addAttribute("item",item);
        model.addAttribute("folder",UPLOAD_DIRECTORY);
        System.out.println("ShowDetailById  ID passed: "+id+", object fetched: "+item);
        System.out.println(System.getProperty("user.dir")+"/img");

        System.out.println(UPLOAD_DIRECTORY);

        return "topics-detail.html";
    }

}
