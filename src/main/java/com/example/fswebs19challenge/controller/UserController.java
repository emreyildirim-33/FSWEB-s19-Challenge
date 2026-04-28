package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins =  "http://localhost:3200")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public String login() {
        return "Tebrikler! Kimlik doğrulandı ve başarıyla giriş yapıldı.";
    }
}
