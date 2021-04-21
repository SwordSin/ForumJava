package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(){
        return "get user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(){
        return "POST user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser(){
        return "PUT user";
    }

}
