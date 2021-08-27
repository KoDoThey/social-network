package com.vcc.intern.socialnetworkapplication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "is_deleted")
    private int isDeleted;
}
