package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {


//    @Query("SELECT u.user_name FROM user u WHERE u.user_name =: userName")
//    public List<String> findUserNameByUserName(@Param("userName") String userName);

    public List<String> findUserNameByUserName(String userName);

}

