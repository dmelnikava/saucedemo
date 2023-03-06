package com.saucedemo.db.service.impl;

import com.saucedemo.db.domain.User;
import com.saucedemo.db.domain.exception.QueryException;
import com.saucedemo.db.persistence.UserRepository;
import com.saucedemo.db.persistence.impl.UserMapperImpl;
import com.saucedemo.db.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserMapperImpl();
    }

    @Override
    public User create(User user) {
        user.setId(null);
        userRepository.create(user);
        return user;
    }

    @Override
    public User read(Long id) {
        return userRepository.read(id)
                .orElseThrow(() -> new QueryException("No users found"));
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}