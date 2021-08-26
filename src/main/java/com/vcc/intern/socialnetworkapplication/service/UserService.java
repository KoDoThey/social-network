package com.vcc.intern.socialnetworkapplication.service;

import com.vcc.intern.socialnetworkapplication.model.User;
import com.vcc.intern.socialnetworkapplication.model.UserLiked;
import com.vcc.intern.socialnetworkapplication.repository.UserLikedRepository;
import com.vcc.intern.socialnetworkapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    
    @Autowired
    UserLikedRepository userLikedRepository;
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setIsDeleted(0);
        userRepository.save(user);
        return user;
    }

    public User getUser(String userId){
        User user = new User();
        userRepository.findUserNameByUserName(userId);
        return user;
    }

    public UserLiked likeUser(String userLikeId, String userLikedId){
        UserLiked userLiked = new UserLiked();
        userLiked.setUserLikeId(userLikeId);
        userLiked.setUserLikedId(userLikedId);
        userLiked.setId(UUID.randomUUID().toString());
        System.out.println(userLiked.toString());

        userLikedRepository.save(userLiked);
        return userLiked;
    }

}
