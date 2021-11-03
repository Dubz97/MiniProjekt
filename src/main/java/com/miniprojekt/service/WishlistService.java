package com.miniprojekt.service;

import com.miniprojekt.Data.WishlistData;
import com.miniprojekt.model.Wishlist;

public class WishlistService {

  WishlistData wishlistData = new WishlistData();


    public void postWishlistDetails(Wishlist wishlist) {
      wishlistData.postUserDetails(wishlist);
    }

}
