package com.example.demo.controller.requestmodel;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Service
@Data
public class Password {

    private Long id;

    private String password;
    private String confirmpassword;
}
