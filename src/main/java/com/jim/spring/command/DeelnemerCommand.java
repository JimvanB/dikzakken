package com.jim.spring.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by jim on 26-11-17.
 */
public class DeelnemerCommand {

    @NotBlank(message = "Cannot be empty")
    @NotNull(message = "Cannot be empty")
    String name;

    @NotBlank(message = "Cannot be empty")
    @NotNull(message = "Cannot be empty")
    @Email(message = "Enter an correct emailadress")
    String email;

    public DeelnemerCommand() {
    }

    public DeelnemerCommand(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
