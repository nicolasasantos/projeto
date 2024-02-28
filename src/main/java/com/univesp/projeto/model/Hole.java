package com.univesp.projeto.model;

import io.micrometer.observation.Observation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Hole {
    private long id;
    private String name;
    private Date date;
    private String latitude;
    private String longitude;
    private String Observation;
    private boolean Fixed;
    private long Foto;

    public Hole(long id, String name, Date date, String latitude, String longitude, String observation, boolean fixed, long foto) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        Observation = observation;
        Fixed = fixed;
        Foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    public boolean isFixed() {
        return Fixed;
    }

    public void setFixed(boolean fixed) {
        Fixed = fixed;
    }

    public long getFoto() {
        return Foto;
    }

    public void setFoto(long foto) {
        Foto = foto;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", Observation='" + Observation + '\'' +
                ", Fixed=" + Fixed +
                ", Foto=" + Foto +
                '}';
    }
}