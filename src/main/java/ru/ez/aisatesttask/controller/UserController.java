package ru.ez.aisatesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ez.aisatesttask.domain.Role;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<User> userList() {
        return userService.findAll();
    }

    @GetMapping("profile/{user_id}")
    public User getProfile(@PathVariable long user_id) {
        return userService.findById(user_id);
    }

    @PostMapping("profile/{user_id}")
    public void updateProfile(
            @PathVariable long user_id,
            @RequestParam String password,
            @RequestParam String email) {
        userService.updateProfile(userService.findById(user_id), password, email);;
    }
}
