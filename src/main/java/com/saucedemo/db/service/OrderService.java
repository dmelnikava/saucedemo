package com.saucedemo.db.service;

import com.saucedemo.db.domain.Order;

public interface OrderService {

    Order create(Long userId, Order order);

    Order read(Long id);

    void update(Order order);

    void delete(Long id);

}