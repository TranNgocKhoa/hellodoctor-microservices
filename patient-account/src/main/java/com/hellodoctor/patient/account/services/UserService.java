package com.hellodoctor.patient.account.services;

import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDetail> createPatientUser(UserRegister userRegister);
}
