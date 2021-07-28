package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.PostLiked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikedRepository extends JpaRepository<PostLiked, String> {
}
