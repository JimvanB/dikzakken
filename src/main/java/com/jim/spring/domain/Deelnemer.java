package com.jim.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
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
        return metingen.get(0);
    }

    public Meeting getLaatsteMeeting(){
        return metingen.get(metingen.size()-1);
    }

    public Double getGewichtVerschilInPercentage(){
        Double verschil = (getLaatsteMeeting().getGewicht() - getNulMeeting().getGewicht())/getNulMeeting().getGewicht()*100;
        return Math.round(verschil *100.0)/100.0;
    }

    public String getGewichtPercentageString(){
        return "("+getGewichtVerschilInPercentage()+"%)";
    }



}
