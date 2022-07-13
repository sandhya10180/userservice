package com.example.demo.repository;

import com.example.demo.Models.Status;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo extends CrudRepository<Status,Integer> {
//    @Query(value = "select * from status where id = ?1",nativeQuery = true)
//    Status getStatus(int id);

    @Query(value = "select * from status where status = ?1",nativeQuery = true)
    Status getStatus(String status);
}
