package com.vcc.intern.socialnetworkapplication.controller;

import com.vcc.intern.socialnetworkapplication.model.User;
import com.vcc.intern.socialnetworkapplication.model.UserInfo;
import com.vcc.intern.socialnetworkapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully!";
    }
//
//    @GetMapping("/get/{userId}")
//    public User getUser(@PathVariable(name = "userId") String userId) {
//        return userService.getUser(userId);
//    }


    @PostMapping("/like/{userLikedId}")
    public String likeUser(@PathVariable(name = "userLikedId") String userLikedId,
                           @RequestBody UserInfo userInfo) {
        System.out.println(userInfo.getUserId());
        userService.likeUser(userInfo.getUserId(), userLikedId);
        return "Liked other user!";
    }
}
