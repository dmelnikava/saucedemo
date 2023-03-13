package com.saucedemo.db.service;

import com.saucedemo.db.domain.User;

public interface UserService {

    User create(User user);

    User read(Long userId, Long orderId);

    void update(User user);

    void delete(Long id);

}