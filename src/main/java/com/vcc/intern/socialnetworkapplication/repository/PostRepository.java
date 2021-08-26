package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    public Post findPostByPostId(String postId);

    public List<Post> findPostByUserId(String userId);

    public List<Post> findAllByIsDeleted(Integer isDeleted);


}
