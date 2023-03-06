package com.saucedemo.db.persistence.impl;

import com.saucedemo.db.domain.User;
import com.saucedemo.db.persistence.MyBatisConfig;
import com.saucedemo.db.persistence.UserRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class UserMapperImpl implements UserRepository {

    @Override
    public void create(User user) {
        try(SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.create(user);
        }
    }

    @Override
    public Optional<User> read(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.read(id);
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.delete(id);
        }
    }
}