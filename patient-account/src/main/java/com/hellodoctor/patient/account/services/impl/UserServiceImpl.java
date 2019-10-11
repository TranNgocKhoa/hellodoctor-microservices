package com.hellodoctor.patient.account.services.impl;

import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import com.hellodoctor.patient.account.mappers.UserMapper;
import com.hellodoctor.patient.account.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mono<UserDetail> createPatientUser(UserRegister userRegister) {
        return userMapper.getUserDetailById(1L);
    }

}
