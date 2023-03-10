package com.saucedemo.db.service;

import com.saucedemo.db.domain.Order;

import java.util.List;

public interface OrderService {

    Order create(Long userId, Order order);

    List<Order> read(Long userId);

    void update(Order order);

    void delete(Long id);

}