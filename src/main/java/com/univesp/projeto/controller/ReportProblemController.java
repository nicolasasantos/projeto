package com.univesp.projeto.controller;
import com.univesp.projeto.model.Hole;
import com.univesp.projeto.repository.DatabaseService;
import com.univesp.projeto.repository.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

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
//        StringBuilder fileNames = new StringBuilder();
//        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
//        //Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY);
//        fileNames.append(file.getOriginalFilename());
//        //fileNames.append(maxId+1);
//        Files.write(fileNameAndPath, file.getBytes());
//        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());

        if(!file.isEmpty()){
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            FileUploadUtil.saveFile(UPLOAD_DIRECTORY,maxId.toString()+".HEIC",file);
            javaxt.io.Image image = new javaxt.io.Image(UPLOAD_DIRECTORY+"/"+maxId.toString()+".HEIC");
            double[] gps = image.getGPSCoordinate();

            hole.setFoto(maxId);
            hole.setDate(timeStamp);
            hole.setLatitude(Double.toString(gps[1]));
            hole.setLongitude(Double.toString(gps[0]));

        }else{
            hole.setFoto(999);
            hole.setDate(timeStamp);
            hole.setLatitude("1");
            hole.setLongitude("1");

        }
        db.addHole(hole);
        return "redirect:index";
    }
}