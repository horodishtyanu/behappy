package com.serverside.behappy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @GetMapping("/main")
    public String mainRest(){
        return "MainApiController";
    }

}
