package com.revature.moneytransfer.controller;
import com.revature.moneytransfer.auth.AuthRequest;
import com.revature.moneytransfer.entity.User;
import com.revature.moneytransfer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class UserController {

    @Autowired
    private UserServiceImpl service;


    @GetMapping("/users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{email}")
    public User findUserByEmail(@PathVariable String email ) {
        return service.getUserByEmail(email);
    }
}