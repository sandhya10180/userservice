package com.example.demo.service;

import com.example.demo.Models.Login;
import com.example.demo.Models.User;
import com.example.demo.controller.requestmodel.UserRes;
import com.example.demo.repository.LoginRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    FileUploadService fileUploadService;

    public ResponseEntity<String> register(User user) throws IOException {
        if (loginRepo.getEmail(user.getLogins().getEmail()) == null ) {
            BCryptPasswordEncoder bCryptPasswordEncoder =
                    new BCryptPasswordEncoder();
            String encodedPassword = bCryptPasswordEncoder.encode(user.getLogins().getPassword());

//            String filename=fileUploadService.uploadFile(file);
//           user.setImage(filename);
//
            Login login = new Login();

            login.setEmail(user.getLogins().getEmail());
            login.setPassword(encodedPassword);
            user.setLogins(login);

            userRepo.save(user);
            return ResponseEntity.ok("User Registered successfully");
       }
         return ResponseEntity.accepted().body("make sure you enter unique username/email");
    }

    public ResponseEntity<String> changePassword(String password,String confirmPassword,long userid) {
        if (password.equals(confirmPassword)) {
                loginRepo.checkPass(password,userid);
                return ResponseEntity.ok("Password changed successfully");
        }
        return ResponseEntity.accepted().body("password and confirm password should be same");
    }

    public UserRes fetchUserByID(Long id) {
        User user;
        UserRes userRes = new UserRes();
        user = userRepo.getUser(id);
        if(user != null) {
            userRes.setId(user.getUser_id());
            userRes.setFirstname(user.getFirstname());
            userRes.setImage(user.getImage());
            userRes.setLocation(user.getLocation());
        }
        return userRes;
    }

    public Map<String, String> signin(Login login) {
        Map<String, String> map = new HashMap<String, String>();
        String userid = "None";
        if(loginRepo.checkEmail(login.getEmail(),login.getPassword()) == null) {
            map.put("response", "fail");
            map.put("userid",userid);
            return map;
        }
        Login log = loginRepo.checkEmail(login.getEmail(),login.getPassword());
         userid = String.valueOf(log.getUserid());
        map.put("response", "success");
        map.put("userid",userid);
        return map;
    }

    public ResponseEntity<String> edit(long userid, User user) {
        Optional<User> us = Optional.of(new User());
        User u = new User();
        if(userRepo.findById(userid) != null){

           // user.setUser_id(userid);
            u.setUser_id(userid);
            u.setFirstname(user.getFirstname());
            u.setLastname(user.getLastname());
            u.setImage(user.getImage());
            u.setLocation(user.getLocation());
            u.setGithub(user.getGithub());
            u.setCreated_at(user.getCreated_at());
            u.setIs_active(user.getIs_active());
            u.setIs_admin(user.getIs_admin());
            u.setIs_superuser(user.getIs_superuser());
            u.setIs_blocked(user.getIs_blocked());
            u.setLogins(userRepo.findById(userid).get().getLogins());
            userRepo.save(u);
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }

    public ResponseEntity<String> delete(long userid) {
        if (userRepo.findById(userid) == null)
        {
            return ResponseEntity.ok("no user exist");
        }
        userRepo.deleteById(userid);
        return ResponseEntity.ok("success");
    }
}
