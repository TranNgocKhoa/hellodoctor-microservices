package com.hellodoctor.patient.account.mappers;

import com.hellodoctor.patient.account.models.UserDetail;
import org.apache.ibatis.annotations.Param;
import reactor.core.publisher.Mono;

public interface UserMapper {

    Mono<UserDetail> getUserDetailById(@Param("userId") Long userId);
}
