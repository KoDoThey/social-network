package com.vcc.intern.socialnetworkapplication.repository.jpa;

import com.vcc.intern.socialnetworkapplication.model.UserLiked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserLikedRepository extends JpaRepository<UserLiked, String> {


}
