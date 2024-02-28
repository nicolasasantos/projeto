package com.univesp.projeto.repository;

import com.univesp.projeto.model.Hole;
import com.univesp.projeto.model.HoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DatabaseService {

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    JdbcTemplate template;


    public List<Hole> getHoles(){
        String query = "SELECT * FROM HOLE";

        return template.query(query,new HoleMapper());
    }
    public Hole getHoleById(long id){
        String query = "SELECT * FROM HOLE WHERE ID = ?";
        return template.queryForObject(query,new Object[] {id},new HoleMapper());
    }

    public void addHole(Hole hole){
        String query = "INSERT INTO HOLE (NAME,DATE,LATITUDE,LONGITUDE,OBS,FIXED,FOTO_ID) VALUES (?,?,?,?,?,?,?)";
        template.update(query,hole.getName(),hole.getDate(),hole.getLatitude(),hole.getLongitude(),hole.getObservation(),hole.isFixed(),hole.getFoto());
    }

}