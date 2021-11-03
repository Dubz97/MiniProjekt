package com.miniprojekt.controller;

import com.miniprojekt.data.UserData;
import com.miniprojekt.model.User;
import com.miniprojekt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

    @Controller
    public class
    MainController {
        UserService userService = new UserService();
        UserData userData = new UserData();
        @GetMapping("/")
        public String index() {
//            userData.setConnection();
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
                return "welcome";
            }
        }
    }


