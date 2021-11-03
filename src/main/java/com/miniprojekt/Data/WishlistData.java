package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WishlistData {

  public void postUserDetails(Wishlist wishlist) {
    Connection conn = DBManager.getConnection();
    String query = "insert into Wishlist(wish, quantity) values (?,?)";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = conn.prepareStatement(query);
      preparedStatement.setString(1, wishlist.getWish());
      preparedStatement.setString(2, String.valueOf(wishlist.getQuantity()));
      preparedStatement.executeUpdate();
    } catch (Exception ignore) {

    }
  }
}
