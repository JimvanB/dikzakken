package com.jim.spring.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by jim on 10-11-17.
 */
@Getter
@Setter
@NoArgsConstructor
public class MeetingCommand {

    @NotNull(message = "omvang mag niet leeg zijn")
    Double omvang;
    @NotNull(message = "gewicht mag niet leeg zijn")
    Double gewicht;
    @NotNull(message = "naam mag niet leeg zijn")
    String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "datum mag niet leeg zijn")
    LocalDate time;

    public MeetingCommand(LocalDate time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOmvang() {
        return omvang;
    }

    public void setOmvang(Double omvang) {
        this.omvang = omvang;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
