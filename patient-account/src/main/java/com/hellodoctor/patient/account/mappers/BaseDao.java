package com.hellodoctor.patient.account.mappers;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public abstract class BaseDao {

    private final SqlSessionFactory sqlSessionFactory;

    public BaseDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    protected <R> Mono<R> apply(Function<SqlSession, R> function) {
        return Mono.just(applyFunction(function));
    }

    private <R> R applyFunction(Function<SqlSession, R> function) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return function.apply(session);
        }
    }
}
