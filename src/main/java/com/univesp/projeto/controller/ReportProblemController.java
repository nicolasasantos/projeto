package com.univesp.projeto.controller;
import com.univesp.projeto.model.Hole;
import com.univesp.projeto.repository.DatabaseService;
import com.univesp.projeto.repository.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;

@Controller
public class ReportProblemController {
    @Autowired
    DatabaseService db;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/img";


    @GetMapping({"/report-problem","/report-problem.html"})
    public String showIndex(ModelMap model){
        Long maxId = db.getMaxId();
        Hole Hole = new Hole();
        model.addAttribute("title","Univesp - Projeto Grupo 9");
        model.addAttribute("grupo","Grupo 9");
        model.addAttribute("maxId",maxId+1);
        model.addAttribute("hole",Hole);

        return "report-problem";
    }

    @PostMapping({"/report-problem","/report-problem.html"})
    public String uploadImage(Hole hole, @RequestParam("image") MultipartFile file) throws IOException {
        Long maxId = db.getMaxId()+1;
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Original file name, being uploaded: "+file.getOriginalFilename());
        if(!file.isEmpty()){
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            FileUploadUtil.saveFile(UPLOAD_DIRECTORY,fileName,file);
            javaxt.io.Image image = new javaxt.io.Image(UPLOAD_DIRECTORY+"/"+fileName);
            double[] gps = image.getGPSCoordinate();

            hole.setFotoId(fileName);
            hole.setDate(timeStamp);
            hole.setLatitude(Double.toString(gps[1]));
            hole.setLongitude(Double.toString(gps[0]));

        }else{
            hole.setFotoId(null);
            hole.setDate(timeStamp);
            hole.setLatitude("1");
            hole.setLongitude("1");

        }
        db.addHole(hole);
        return "redirect:index";
    }
}