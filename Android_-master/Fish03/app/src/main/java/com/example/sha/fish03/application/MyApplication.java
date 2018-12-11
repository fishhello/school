package com.example.sha.fish03.application;

import com.example.sha.fish03.entity.User;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

public class MyApplication extends LitePalApplication {
    public String appVersion = "v1.0";
    private static MyApplication instance;

    //当前登录用户
    private User loginUser = new User();

    public User getLoginUser(){
        return loginUser;
    }

    public void userLogin(User user){
        loginUser.setId(user.getId());
        loginUser.setUsername(user.getUsername());
    }

    public void userLogout(){
        loginUser = new User();
    }

    public static MyApplication getInstance() {
        return  instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        LitePal.initialize(this);
    }
}
