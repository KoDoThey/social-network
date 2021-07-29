package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Data
@Entity
public class PostLiked {
    @Id
    private String postLikedId;
    private String userId;
    private String postId;
    private Timestamp likedTime;
}
