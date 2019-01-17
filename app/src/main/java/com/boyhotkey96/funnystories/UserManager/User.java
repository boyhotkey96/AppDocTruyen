package com.boyhotkey96.funnystories.UserManager;

/**
 * Created by boyhotkey96 on 21/11/2017.
 */

public class User {

    private String username;
    private String email;
    private String password;

    /*Contructor*/
    public User() {
    }

    /*Setter*/
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /*Getter*/
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
