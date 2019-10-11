package com.hellodoctor.patient.account.controllers;

import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import com.hellodoctor.patient.account.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<UserDetail> register(UserRegister user) {
        return userService.createPatientUser(user);
    }

    @GetMapping("/{id}")
    public Mono<UserDetail> getUserById(Long id) {
        return userService.createPatientUser(null);
    }
}
