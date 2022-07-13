package com.example.demo.repository;

import com.example.demo.Models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface LoginRepo extends JpaRepository<Login,Long> {

    @Query(
            value = "SELECT * FROM login WHERE EMAIL = ?1",
            nativeQuery = true)
    Login getEmail(String mail);

    @Transactional
    @Modifying
    @Query(
            value = "update login set password = password(?1) where userid = ?2",
            nativeQuery = true)
    int checkPass(String pass,long userid);


    @Query(
            value = "select * from login where email = ?1 and password = ?2",
            nativeQuery = true)
    Login checkEmail(String email,String password);

}
