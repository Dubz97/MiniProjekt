package com.miniprojekt.Data;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.model.Joined;
import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistData {

  public void postUserDetails(Wishes wishes) {
    User user = new User();
    Connection conn = DBManager.getConnection();


    String query = "INSERT INTO wishes(wish, quantity, idWishlist) VALUES (?,?,?) " +
        "FROM accounts, wishlist " +
        "WHERE accounts.accountid = wishlist.userId";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = conn.prepareStatement(query);
      preparedStatement.setString(1, wishes.getWish());
      preparedStatement.setInt(2, wishes.getQuantity());
      preparedStatement.setInt(3,1);

      preparedStatement.executeUpdate();
    } catch (Exception ignore) {

    }
  }
  public List<Joined> findWishes (){
    List<Joined> result = new ArrayList<>();
    Connection connection = DBManager.getConnection();
    String SQL = "SELECT accounts.accountid, Wishlist.id, Wishlist.wish, Wishlist.quantity" +
        " FROM accounts, Wishlist " +
        " WHERE accounts.accountid = Wishlist.userId";



    try{
      PreparedStatement ps = connection.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
        result.add(new Joined(rs.getInt("accountid"),
                rs.getInt("id"),
                rs.getString("wish")));
      }
    } catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }


}
