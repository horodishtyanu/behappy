package com.serverside.behappy.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverside.behappy.models.User;
import com.serverside.behappy.models.UserAuth;
import com.serverside.behappy.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    private final UserRepo userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public Object userRegister(@RequestBody String json){
        ObjectMapper om = new ObjectMapper();
        User newUser = new User();
        try {
            newUser = om.readValue(json, User.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        if (!userRepo.findAllByEmail(newUser.getEmail()).isEmpty()){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        String password = this.bCryptPasswordEncoder.encode(newUser.getPassword());
        newUser.setPassword(password);

        userRepo.save(newUser);
        return newUser;
    }

    @PostMapping("/auth")
    public Object userAuth(@RequestBody String json){
        UserAuth uauth = new UserAuth();
        ObjectMapper om = new ObjectMapper();
        try {
            uauth = om.readValue(json, UserAuth.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        String email = uauth.getEmail();
        String password = uauth.getPassword();


        User user = userRepo.findUserByEmail(email);
        if (user == null){
            return new ResponseEntity<>("No user exists!", HttpStatus.BAD_REQUEST);
        }else  if ( !bCryptPasswordEncoder.matches(password, user.getPassword())){
            return new ResponseEntity<>("Login or password is incorrect!!!", HttpStatus.BAD_REQUEST);
        }
        return user;
    }
}
