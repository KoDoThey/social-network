package com.vcc.intern.socialnetworkapplication.service;

import com.vcc.intern.socialnetworkapplication.model.Post;
import com.vcc.intern.socialnetworkapplication.model.PostLiked;
import com.vcc.intern.socialnetworkapplication.repository.PostLikedRepository;
import com.vcc.intern.socialnetworkapplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostLikedRepository postLikedRepository;

    public Post getPost(String postId) {
        return postRepository.findPostByPostId(postId);
    }

    public List<Post> getPostsAvailable() {
        return postRepository.findAllByIsDeleted(0);
    }

    public Post addPost(Post post) {
        post.setPostId(UUID.randomUUID().toString());
        post.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        post.setIsDeleted(0);
        return postRepository.save(post);
    }

    public String getPostId(String postId) {
        if (postRepository.findPostByPostId(postId) != null) {
            return postId;
        } else return null;
    }

    public Post editPost(String postId, Post post) {
        post.setPostId(postId);
        return postRepository.save(post);
    }

    public PostLiked likePost(String postId, String userId) {
        PostLiked postLiked = new PostLiked();
        postLiked.setPostLikedId(UUID.randomUUID().toString());
        postLiked.setPostId(postId);
        postLiked.setUserId(userId);
        postLiked.setLikedTime(Timestamp.valueOf(LocalDateTime.now()));
        return postLikedRepository.save(postLiked);
    }


}
