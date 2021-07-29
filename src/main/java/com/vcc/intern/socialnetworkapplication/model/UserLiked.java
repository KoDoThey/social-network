package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Data
@Entity
public class UserLiked {
    @Id
    private String userLikedId;
    private String userIdLike;
    private String userIdLiked;
    private int match;
}
