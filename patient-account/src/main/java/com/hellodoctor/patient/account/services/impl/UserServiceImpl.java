package com.hellodoctor.patient.account.services.impl;

import com.hellodoctor.patient.account.enums.ErrorType;
import com.hellodoctor.patient.account.exceptions.DBOperationException;
import com.hellodoctor.patient.account.mappers.ProfileMapper;
import com.hellodoctor.patient.account.mappers.UserMapper;
import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import com.hellodoctor.patient.account.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    @Transactional
    public Mono<UserDetail> createPatientUser(UserRegister userRegister) {
        boolean insertUserSuccess = userMapper.insertUser(userRegister);
        boolean insertProfileSuccess = profileMapper.insertProfile(userRegister);
        if (insertUserSuccess && insertProfileSuccess) {
            return Mono.justOrEmpty(userMapper.getUserDetailById(userRegister.getId()));
        } else {
            throw new DBOperationException(ErrorType.INSERT_FAIL);
        }
    }

    @Override
    public Mono<UserDetail> getPatientUserById(Long id) {
        return Mono.justOrEmpty(userMapper.getUserDetailById(id));
    }

    @Override
    public Mono<UserDetail> updateUserInformation(UserDetail user) {
        boolean updateUserSuccess = userMapper.updateUserInformation(user);
        boolean updateProfileSuccess = profileMapper.updateProfileInformation(user);
        if (updateUserSuccess && updateProfileSuccess) {
            return Mono.justOrEmpty(userMapper.getUserDetailById(user.getId()));
        } else {
            throw new DBOperationException(ErrorType.UPDATE_FAIL);
        }
    }

}
