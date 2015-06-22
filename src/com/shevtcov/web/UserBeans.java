package com.shevtcov.web;

import com.shevtcov.objects.User;

import java.util.ArrayList;

/**
 * Created by deadRabbit on 18.06.2015.
 */
public class UserBeans {

    private User user = new User();
    private ArrayList<User> list = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
