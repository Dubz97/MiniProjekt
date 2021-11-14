package com.miniprojekt.Controllers;

import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;
import com.miniprojekt.service.UserService;
import com.miniprojekt.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class MyController {
  UserService userService = new UserService();
  WishlistService wishlistService = new WishlistService();


  @GetMapping("/")
  public String index(Model model, User user) {
    model.addAttribute("user", user);
    return "index";
  }

  @PostMapping("/index/submit")
  public String indexSubmit(WebRequest request, User user) {
    setSessionInfo(request, user);
    userService.postUserDetails(user);
    wishlistService.showWishlistUserId(user);

    return "index";
  }

  private void setSessionInfo(WebRequest request, User user) {
    // Place user info on session
    request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
  }

  @PostMapping("/index/login")
  public String indexLogin(WebRequest request, Model model, User user) {

    User loggedIn = userService.checkLogin(user);

    if(loggedIn==null){
      model.addAttribute("loginError",true);
      return "index";
    } else {
      setSessionInfo(request, loggedIn);
      model.addAttribute("loginSucces", true);
      return "redirect:/personallist";
    }
  }

  @GetMapping("/personallist")
  public String personalList(Model model, WebRequest request, Wishes wishes) {
    User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    model.addAttribute("wishes", wishes);
    model.addAttribute("user", user);

    List<Wishes>wishlist = wishlistService.findWishes(user.getId());
    model.addAttribute("wishlist", wishlist);
    return "personalList";
  }



  @PostMapping("/personallist")
  public String save(WebRequest request, Wishes wishes)  {
    User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    wishes.setIdWishlist(user.getId());
    wishlistService.postWishlistDetails(wishes);
    return "redirect:/personallist";
  }
}
