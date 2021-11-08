package com.miniprojekt.Controllers;

import com.miniprojekt.model.User;
import com.miniprojekt.model.Wishes;
import com.miniprojekt.service.UserService;
import com.miniprojekt.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MyController {
  UserService userService = new UserService();
  WishlistService wishlistService = new WishlistService();
  @GetMapping("/")
  public String index() {

    return "index";
  }
  @PostMapping("/index/submit")
  public String indexSubmit(WebRequest request) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setFname(fname);
    user.setLname(lname);
    userService.postUserDetails(user);
    return "index";
  }

  @PostMapping("/index/login")
  public String indexLogin(WebRequest request, Model model) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    User loggedIn = userService.checkLogin(user);
    String s = "";
    if(loggedIn==null){
      model.addAttribute("loginError",true);
      return "index";
    } else {
      model.addAttribute("loginSucces", true);
      return "personallist";
    }
  }
  @GetMapping("/personallist")
  public String personalList() {
    return "personalList";
  }



  @PostMapping("/personallist")
  public String save(WebRequest request)  {
    String wish = request.getParameter("wish");
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    Wishes wishes = new Wishes();
    wishes.setWish(wish);
    wishes.setQuantity(quantity);
    wishlistService.postWishlistDetails(wishes);
    ;
    return "personallist";
  }
@GetMapping("/findwishes")
@ResponseBody
  public String findWishes(){
    return wishlistService.findWishes().toString();
}
}
