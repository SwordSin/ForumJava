package com.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @GetMapping(value = "/user")
    public String getUser(){
        return "get user";
    }

    @PostMapping(value = "/user")
    public String saveUser(){
        return "POST user";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser(){
        return "DELETE user";
    }

    @PutMapping(value = "/user")
    public String putUser(){
        return "PUT user";
    }

}
