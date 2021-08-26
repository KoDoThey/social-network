package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "post_id")
    private String postId;
    @Column(name = "content")
    private String content;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "create_time")

    private String createTime;
    @Column(name = "edit_time")
    private String editTime;


    @Column(name = "is_deleted")
    private int isDeleted;
}
