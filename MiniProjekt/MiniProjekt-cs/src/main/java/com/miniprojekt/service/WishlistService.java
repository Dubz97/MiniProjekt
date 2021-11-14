package com.miniprojekt.service;

import com.miniprojekt.Data.WishlistData;
import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;

import java.util.List;

public class WishlistService {

  WishlistData wishlistData = new WishlistData();


    public void postWishlistDetails(Wishes wishes) {
      wishlistData.postUserDetails(wishes);
    }

    public void showWishlistUserId(User user) {
      UserService userService = new UserService();
      userService.wishlistUserId(user);
    }

    public List<Wishes> findWishes(int id){
      return wishlistData.findWishes(id);
    }
}
