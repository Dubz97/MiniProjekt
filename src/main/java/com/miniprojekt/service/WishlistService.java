package com.miniprojekt.service;

import com.miniprojekt.Data.WishlistData;
import com.miniprojekt.model.Joined;
import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;

import java.util.List;

public class WishlistService {

  WishlistData wishlistData = new WishlistData();


    public void postWishlistDetails(Wishes wishes) {
      wishlistData.postUserDetails(wishes);
    }

    public void visPis(User user) {
      UserService userService = new UserService();
      userService.pis(user);
    }

   /* public void visWishlistAcc(Wishes wishes) {
      wishlistData.wishlistAcc(wishes);
    }


    */
    public List<Joined> findWishes(){
      return wishlistData.findWishes();
    }
}
