package com.jim.spring.command;

/**
 * Created by jim on 29-11-17.
 */
public class UserCommand {

    String username;
    String password;

    public UserCommand() {
    }

    public UserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
