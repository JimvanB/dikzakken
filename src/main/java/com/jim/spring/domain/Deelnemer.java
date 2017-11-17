package com.jim.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jim on 10-11-17.
 */
@Entity
public class Deelnemer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(mappedBy = "deelnemer", cascade = CascadeType.ALL)
    List<Meeting> metingen = new ArrayList<>();



    Deelnemer(){}

    public Deelnemer(String name) {
        this.name = name;
        this.metingen = metingen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meeting> getMetingen() {
        return metingen;
    }

    public void setMetingen(List<Meeting> metingen) {
        this.metingen = metingen;
    }

    public void addMeeting(Meeting meeting){
        metingen.add(meeting);
        meeting.setDeelnemer(this);
    }

    public Meeting getNulMeeting(){
        if(!metingen.isEmpty()) {
            return metingen.get(0);
        } return null;
    }

    public Meeting getLaatsteMeeting(){

        if(!metingen.isEmpty()) {
            return metingen.get(metingen.size()-1);
        } return null;
    }

    public Double getGewichtVerschilInPercentage(){
        if(getLaatsteMeeting() != null && getNulMeeting() != null) {
            Double verschil = (getLaatsteMeeting().getGewicht() - getNulMeeting().getGewicht()) / getNulMeeting().getGewicht() * 100;
            return Math.round(verschil * 100.0) / 100.0;
        } else {
            return 0.0;
        }
    }

    public Double getGewichtVerschilAbsoluut(){
        if(getLaatsteMeeting() != null && getNulMeeting() != null) {
            Double verschil = (getLaatsteMeeting().getGewicht() - getNulMeeting().getGewicht());
            return Math.round(verschil * 100.0) / 100.0;
        } else {
            return 0.0;
        }
    }

    public Double getOmvangVerschilAbsoluut(){
        if(getLaatsteMeeting() != null && getNulMeeting() != null) {
            Double verschil = (getLaatsteMeeting().getOmvang() - getNulMeeting().getOmvang());
            return Math.round(verschil * 100.0) / 100.0;
        } else {
            return 0.0;
        }
    }

    public boolean isDikker(){
       return getGewichtVerschilAbsoluut() > 0.0;
    }

    public boolean isVetter(){
        return getOmvangVerschilAbsoluut() > 0.0;
    }

    public String getGewichtPercentageString(){
        if(getGewichtVerschilInPercentage() > 0.0) {
            return "(+" + getGewichtVerschilInPercentage() + "%)";
        }
        return "(" + getGewichtVerschilInPercentage() + "%)";
    }



}
