package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class UserData {
//    public boolean setConnection() {
//        final String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11448176";
//        boolean res = false;
//        try {
//            Connection connection = DriverManager.getConnection(url, "sql11448176", "25eQXYp4yW");
//            res = true;
//            Statement stmt = connection.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS Accounts" +
//                    " (username VARCHAR(255), " +
//                    " password VARCHAR(255), " +
//                    " fname varchar(255), " +
//                    "lname varchar (255),"+
//                    " PRIMARY KEY (id))";
//            stmt.execute(sql);
//            System.out.println("Created table in given database...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("We didnt get connection, error: =" + e.getMessage());
//        }
//        return res;
//    }

        public void postUserDetails(User user) {
            Connection conn = DBManager.getConnection();

            String query = "insert into accounts(id, username, password, fname, lname) values (?,?,?,?,?)";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3,user.getFname());
                preparedStatement.setString(4,user.getLname());

                preparedStatement.executeUpdate();
            } catch (Exception ignore) {

            }
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
                    result = new User(rs.getInt("id"),rs.getString("username"),
                            rs.getString("password"), rs.getString("fname"), rs.getString("lname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }
}
