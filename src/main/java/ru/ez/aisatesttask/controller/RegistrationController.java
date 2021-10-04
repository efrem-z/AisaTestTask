package ru.ez.aisatesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ez.aisatesttask.domain.Role;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.domain.dto.CaptchaResponseDto;
import ru.ez.aisatesttask.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
@RestController
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration/add")
    public void addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phoneNumber
    ) {
        User user = new User(username,password,email,phoneNumber);

        userService.addUser(user);
    }

}
