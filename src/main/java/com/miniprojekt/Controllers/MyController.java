package com.miniprojekt.Controllers;

import com.miniprojekt.model.Wishlist;
import com.miniprojekt.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MyController {

  WishlistService wishlistService = new WishlistService();


  @GetMapping("/personallist")
  public String personalList() {
    return "personalList";
    }



  @PostMapping("/personallist")
  public String save(WebRequest request)  {
    String wish = request.getParameter("wish");
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    Wishlist wishlist = new Wishlist();
    wishlist.setWish(wish);
    wishlist.setQuantity(quantity);
    wishlistService.postWishlistDetails(wishlist);
  return "personallist";
  }

}
