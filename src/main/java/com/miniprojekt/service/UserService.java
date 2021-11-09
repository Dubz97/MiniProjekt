package com.miniprojekt.service;


import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.Data.UserData;
import com.miniprojekt.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
    UserData userdata = new UserData();

    public void postUserDetails(User user) {
        userdata.postUserDetails(user);
    }


    public User checkLogin(User user) {
        return userdata.checkLogin(user);
    }


    public User pis(User user) {
        Connection conn = DBManager.getConnection();
        String query = "insert into wishlist(userId) values (?)";

        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, user.getId());

            preparedStatement.executeUpdate();

            ResultSet ids = preparedStatement.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);

        } catch (Exception ignore) {

        }
        return user;
    }
}
