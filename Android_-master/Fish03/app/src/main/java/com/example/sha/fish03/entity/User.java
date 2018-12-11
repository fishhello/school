package com.example.sha.fish03.entity;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private  int id;

    private String username;

    private String userPass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
