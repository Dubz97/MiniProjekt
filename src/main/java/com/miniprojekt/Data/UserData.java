package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.User;

import java.sql.*;

public class UserData {

        public User postUserDetails(User user) {
            Connection conn = DBManager.getConnection();

            String query = "insert into accounts(username, password, fname, lname) values (?,?,?,?)";
            PreparedStatement preparedStatement;

            try {
                preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getFname());
                preparedStatement.setString(4, user.getLname());


                preparedStatement.executeUpdate();

                ResultSet ids = preparedStatement.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);

            } catch (Exception ignore) {

            }
            return user;
        }
        public User checkLogin(User user){
            User result = null;
            Connection conn = DBManager.getConnection();
            String SQL = "SELECT * FROM accounts where username = ? AND password = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    result = new User(rs.getInt("accountid"),rs.getString("username"),
                            rs.getString("password"), rs.getString("fname"), rs.getString("lname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }
}
