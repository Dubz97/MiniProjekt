package com.miniprojekt.service;

import com.miniprojekt.DBManager.DBManager;
import com.miniprojekt.Data.WishlistData;
import com.miniprojekt.model.Joined;
import com.miniprojekt.model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistService {

  WishlistData wishlistData = new WishlistData();


    public void postWishlistDetails(Wishlist wishlist) {
      wishlistData.postUserDetails(wishlist);
    }
    public List<Joined> findWishes(){
      return wishlistData.findWishes();
    }
}
