package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistData {

  public void
  postUserDetails(Wishlist wishlist) {
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
  public List<Wishlist> findWishes (){
    List<Wishlist> result = new ArrayList<>();
    Connection connection = DBManager.getConnection();
    String SQL = "Select * From Wishlist";
    try{
      PreparedStatement ps = connection.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
        result.add(new Wishlist(rs.getInt("id"),
                rs.getString("wish"),
                rs.getInt("quantity")));
      }
    } catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }
}
