package com.example.demo.controller;

import com.example.demo.Models.Status;
import com.example.demo.repository.StatusRepo;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/status")
@RestController
public class StatusController {
    @Autowired
    StatusService statusService;

    @Autowired
    StatusRepo statusRepo;

    @PostMapping("/addStatus")
    public ResponseEntity<String> insertStatus(@RequestBody Status status)
    {
        return statusService.addStatus(status);
    }
    @PutMapping("/updatestatus/{id}")
    public ResponseEntity<String> updatestatus(@PathVariable int id, @RequestBody Status status)
    {
        return statusService.edit(id,status);
    }
    @GetMapping("/deletestatus/{id}")
    public ResponseEntity<String> deletestatus(@PathVariable int id)
    {
        statusRepo.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
    @GetMapping("/getstatusById/{id}")
    public Optional<Status> getstatusByid(@PathVariable int id)
    {

        return statusRepo.findById(id);
    }

}
