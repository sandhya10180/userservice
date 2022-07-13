package com.example.demo.service;

import com.example.demo.Models.Status;
import com.example.demo.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    StatusRepo statusRepo;

    public  ResponseEntity<String> addStatus(Status status) {
        if (statusRepo.getStatus(status.getStatus())==null) {
            statusRepo.save(status);
            return ResponseEntity.ok("success");
        }
       return ResponseEntity.ok("status already exist");
    }

    public ResponseEntity<String> edit(int id, Status status) {

        Optional<Status> st = statusRepo.findById(id);
        if(st != null) {
           // status.setStatus(st.get().getStatus());
            statusRepo.save(status);
            return ResponseEntity.ok("success");
        }

        return ResponseEntity.ok("fail");
    }
}
