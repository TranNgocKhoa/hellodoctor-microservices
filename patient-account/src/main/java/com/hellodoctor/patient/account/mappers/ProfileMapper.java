package com.hellodoctor.patient.account.mappers;

import com.hellodoctor.patient.account.models.UserDetail;
import com.hellodoctor.patient.account.models.UserRegister;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProfileMapper {

    boolean insertProfile(UserRegister user);

    boolean updateProfileInformation(UserDetail user);

}
