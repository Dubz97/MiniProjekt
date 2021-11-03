package com.miniprojekt.service;

import com.miniprojekt.data.UserData;
import com.miniprojekt.model.User;

public class UserService {
    UserData userdata = new UserData();

    public void postUserDetails(User user) {
        userdata.postUserDetails(user);
    }

    public User checkLogin(User user) {
        return userdata.checkLogin(user);
    }
}
