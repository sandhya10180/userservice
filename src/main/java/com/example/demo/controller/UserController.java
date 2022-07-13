package com.example.demo.controller;


import com.example.demo.Models.Login;
import com.example.demo.Models.User;
import com.example.demo.controller.requestmodel.Password;
import com.example.demo.controller.requestmodel.UserRes;
import com.example.demo.repository.LoginRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    LoginRepo loginRepo;

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) throws IOException {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Login login)
    {
        return userService.signin(login);
    }

    @PostMapping("/changepassword/{userid}")
    public ResponseEntity<String> changepass(@PathVariable long userid, @RequestBody Password password)
    {
        return userService.changePassword(password.getPassword(),password.getConfirmpassword(),userid);
    }

    @GetMapping("/getUser")
    public List<User> getUser()
    {
        return userRepo.findAll();
    }

    @GetMapping("/getUserByID/{id}")
    public UserRes getUserByID(@PathVariable Long id)
    {
        return userService.fetchUserByID(id);
    }

    @PutMapping("/updateUser/{userid}")
    public ResponseEntity<String> updateUser(@PathVariable long userid,@RequestBody User user)
    {
        return userService.edit(userid,user);
    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<String> deleteuser(@PathVariable long userid)
    {
        return userService.delete(userid);
    }
}
