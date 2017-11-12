package com.jim.spring.domain;

import com.jim.spring.convertor.LocalDateTimeConver;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by jim on 10-11-17.
 */
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Deelnemer deelnemer;
    Double gewicht;
    Double omvang;
    @Convert(converter = LocalDateTimeConver.class)
    LocalDateTime time;

    Meeting(){}



    public Meeting(Double gewicht, Double omvang, LocalDateTime time) {
        this.gewicht = gewicht;
        this.omvang = omvang;
        this.time = time;
    }

    public Meeting(Double gewicht, Double omvang) {
        this.gewicht = gewicht;
        this.omvang = omvang;
        this.time = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Deelnemer getDeelnemer() {
        return deelnemer;
    }

    public void setDeelnemer(Deelnemer deelnemer) {
        this.deelnemer = deelnemer;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public Double getOmvang() {
        return omvang;
    }

    public void setOmvang(Double omvang) {
        this.omvang = omvang;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
