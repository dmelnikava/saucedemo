package com.saucedemo.db.persistence;

import com.saucedemo.db.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface UserRepository {

    void create(User user);

    Optional<User> read(@Param("userId") Long userId, @Param("orderId") Long orderId);

    void update(User user);

    void delete(Long id);

}