package com.saucedemo.db.service.impl;

import com.saucedemo.db.domain.Order;
import com.saucedemo.db.domain.exception.QueryException;
import com.saucedemo.db.persistence.OrderRepository;
import com.saucedemo.db.persistence.impl.OrderMapperImpl;
import com.saucedemo.db.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl() {
        this.orderRepository = new OrderMapperImpl();
    }

    @Override
    public Order create(Long userId, Order order) {
        order.setId(null);
        orderRepository.create(userId, order);
        return order;
    }

    @Override
    public Order read(Long id) {
        return orderRepository.read(id)
                .orElseThrow(() -> new QueryException("No orders found"));
    }

    @Override
    public void update(Order order) {
        orderRepository.update(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }
}