package com.serverside.behappy.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverside.behappy.models.User;
import com.serverside.behappy.models.UserAuth;
import com.serverside.behappy.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
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

        List<User> user;
        user = userRepo.findAllByEmailAndPassword(email, password);
        if (user.isEmpty()){
            return new ResponseEntity<>("No user exists!", HttpStatus.BAD_REQUEST);
        }
        return user;
    }
}
