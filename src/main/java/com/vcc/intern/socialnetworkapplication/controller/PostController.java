package com.vcc.intern.socialnetworkapplication.controller;

import com.vcc.intern.socialnetworkapplication.model.Post;
import com.vcc.intern.socialnetworkapplication.model.UserInfo;
import com.vcc.intern.socialnetworkapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        postService.addPost(post);
        System.out.println(post.toString());
        return "Post added!";
    }

    @GetMapping("/get/{postId}")
    public Post getPost(@PathVariable(name = "postId") String postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/get-all")
    public List<Post> getPostsAvailable() {
        System.out.println(postService.getPostsAvailable());
        return postService.getPostsAvailable();
    }

    @PutMapping("/edit/{postId}")
    public String editPost(@PathVariable(name = "postId") String postId,
                           @RequestBody Post post) {
        if (postService.getPostId(postId) == null) {
            return "Post is not exist";
        } else {
            postService.editPost(postId, post);
            return "Post is edited";
        }
    }

    @PostMapping("/like/{postId}")
    public String likePost(@PathVariable(name = "postId") String postId,
                           @RequestBody UserInfo userInfo) {
        postService.likePost(postId, userInfo.getUserId());
        return "Liked post!";
    }
}
