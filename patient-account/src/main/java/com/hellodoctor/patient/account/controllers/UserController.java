package com.hellodoctor.patient.account.controllers;

import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import com.hellodoctor.patient.account.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<UserDetail> register(@RequestBody UserRegister user) {
        return userService.createPatientUser(user);
    }

    @PutMapping
    public Mono<UserDetail> update(@RequestBody UserDetail user) {
        return userService.updateUserInformation(user);
    }

    @GetMapping("/{id}")
    public Mono<UserDetail> getUserById(@PathVariable Long id) {
        return userService.getPatientUserById(id);
    }

}
