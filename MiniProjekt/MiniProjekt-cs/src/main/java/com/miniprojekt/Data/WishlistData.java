package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.Joined;
import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WishlistData {

  public void postUserDetails(Wishes wishes) {
    User user = new User();
    Connection conn = DBManager.getConnection();


    String query = "INSERT INTO wishes(wish, quantity, idWishlist) VALUES (?,?,?) ";
    PreparedStatement preparedStatement;


    try {
      preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, wishes.getDescription());
      preparedStatement.setInt(2, wishes.getQuantity());
      preparedStatement.setInt(3, wishes.getIdWishlist());

      preparedStatement.executeUpdate();

      ResultSet ids = preparedStatement.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      wishes.setIdWishlist(id);



    } catch (Exception ignore) {

    }
  }

  public List<Wishes> findWishes(int id) {
    List<Wishes> result = new ArrayList<>();
    Connection connection = DBManager.getConnection();
    String SQL = "SELECT * " +
        " FROM wishes " +
        " WHERE wishes.idWishlist = " + id;


    try {
      PreparedStatement ps = connection.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Wishes wishes = new Wishes();
        wishes.setDescription(rs.getString("wish"));
        wishes.setQuantity(rs.getInt("quantity"));
       result.add(wishes);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  /*
  public Wishes wishlistAcc(Wishes wishes) {
  Connection conn = DBManager.getConnection();
  String query = "insert into wishes(idWishlist) values (?)";

  PreparedStatement preparedStatement;

        try {
    preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

    preparedStatement.setInt(1, wishes.getIdWishlist());

    preparedStatement.executeUpdate();

    ResultSet ids = preparedStatement.getGeneratedKeys();
    ids.next();
    int id = ids.getInt(1);
    wishes.setIdWishlist(id);

  } catch (Exception ignore) {

  }
        return wishes;
}


   */
}
