package com.vcc.intern.socialnetworkapplication.repository;

import com.vcc.intern.socialnetworkapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
