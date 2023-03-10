package com.saucedemo.db.service.impl;

import com.saucedemo.db.domain.Order;
import com.saucedemo.db.persistence.OrderRepository;
import com.saucedemo.db.persistence.impl.OrderMapperImpl;
import com.saucedemo.db.service.OrderService;

import java.util.List;

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
    public List<Order> read(Long userId, Long orderId) {
        return orderRepository.read(userId, orderId);
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