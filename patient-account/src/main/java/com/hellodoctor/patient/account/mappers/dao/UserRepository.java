package com.hellodoctor.patient.account.mappers.dao;

import com.hellodoctor.patient.account.mappers.BaseDao;
import com.hellodoctor.patient.account.mappers.UserMapper;
import com.hellodoctor.patient.account.models.UserDetail;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository extends BaseDao implements UserMapper {

    private static final String MAPPER_CLASS = "com.hellodoctor.patient.account.mappers.UserMapper.";

    public UserRepository(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Mono<UserDetail> getUserDetailById(Long userId) {
        return this.apply((session) -> session.selectOne(MAPPER_CLASS + "getUserDetailById", userId));
    }
}
