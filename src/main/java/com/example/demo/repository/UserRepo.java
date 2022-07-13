package com.example.demo.repository;

import com.example.demo.Models.User;
import com.example.demo.controller.requestmodel.UserRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select * from user where user_id = ?1",nativeQuery = true)
    User getUser(Long id);


}
