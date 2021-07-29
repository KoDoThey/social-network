package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;

@Data
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    private int isDeleted;
}
