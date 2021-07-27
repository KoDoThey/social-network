package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "post")
public class Post {
    @Id
    private String postId;
    private String content;
    private String userId;
    private Timestamp createTime;
    private Timestamp editTime;
    private int isDeleted;
}
