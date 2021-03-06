package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_liked")
public class UserLiked {
    @Id
    @Column(name = "user_liked_id")
    private String Id;

    @Column(name = "user_id_like")
    private String userLikeId;

    @Column(name = "user_id_liked")
    private String userLikedId;

    @Column(name = "matched")
    private int matched;
}
