package com.rmu.invoice.controller;

import com.rmu.invoice.model.User;
import com.rmu.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        UserController.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
