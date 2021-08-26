package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "post_liked")
public class PostLiked {
    @Id
    @Column(name = "post_liked_id")
    private String postLikedId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "post_id")
    private String postId;
    @Column(name = "liked_time")
    private Timestamp likedTime;
}
