package com.vcc.intern.socialnetworkapplication.controller;

import com.vcc.intern.socialnetworkapplication.model.Post;
import com.vcc.intern.socialnetworkapplication.model.User;
import com.vcc.intern.socialnetworkapplication.repository.PostRepository;
import com.vcc.intern.socialnetworkapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        postService.addPost(post);
        return "Add success!";
    }

    @GetMapping("/get/{postId}")
    public Post getPost(@PathVariable(name = "postId") String postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/get-all")
    public List<Post> getPostsAvailable() {
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
                           @RequestBody String userId) {
        postService.likePost(postId, userId);
        return "Liked post!";
    }
}
