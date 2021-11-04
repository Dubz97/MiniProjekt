package com.miniprojekt.JDBCWriter;

import java.sql.*;


  public class JDBCWriter {

    private Connection connection;

    public boolean setConnection() {
      final String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11448176";
      boolean res = false;


      try {
        connection = DriverManager.getConnection(url, "sql11448176", "25eQXYp4yW");
        res = true;

        Statement stmt = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS Wishlist" +
                " (id INTEGER NOT NULL AUTO_INCREMENT, " +
                " wish VARCHAR(255), " +
                " quantity INTEGER, " +
                " PRIMARY KEY ( id ))";
        stmt.execute(sql);
        System.out.println("Created table in given database...");

      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("We didnt get connection, error: =" + e.getMessage());

      }
      return res;
    }
    public boolean setConnection2() {
      final String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11448176";
      boolean res = false;


      try {
        connection = DriverManager.getConnection(url, "sql11448176", "25eQXYp4yW");
        res = true;

        Statement stmt = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS accounts" +
                " (id INTEGER NOT NULL AUTO_INCREMENT, " +
                " username VARCHAR(255), " +
                " password varchar (255), " +
                " fname varchar (255)," +
                " lname varchar (255)," +
                " PRIMARY KEY ( id ))";
        stmt.execute(sql);
        System.out.println("Created table in given database...");

      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("We didnt get connection, error: =" + e.getMessage());

      }
      return res;
    }

  }
