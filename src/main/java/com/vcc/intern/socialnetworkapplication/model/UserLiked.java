package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserLiked {
    @Id
    private String userLikedId;
    private String userId1;
    private String userId2;
}
