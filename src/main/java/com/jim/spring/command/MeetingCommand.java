package com.jim.spring.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    LocalDateTime time;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
