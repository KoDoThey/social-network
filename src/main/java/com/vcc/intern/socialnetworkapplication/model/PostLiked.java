package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

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
