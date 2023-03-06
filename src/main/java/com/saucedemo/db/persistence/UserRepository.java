package com.saucedemo.db.persistence;

import com.saucedemo.db.domain.User;

import java.util.Optional;

public interface UserRepository {

    void create(User user);

    Optional<User> read(Long id);

    void update(User user);

    void delete(Long id);

}