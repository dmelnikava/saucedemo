package com.saucedemo.db.persistence.impl;

import com.saucedemo.db.domain.Item;
import com.saucedemo.db.domain.Order;
import com.saucedemo.db.persistence.MyBatisConfig;
import com.saucedemo.db.persistence.OrderRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderMapperImpl implements OrderRepository {

    @Override
    public void create(Long userId, Order order) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.create(userId, order);
        }
    }

    @Override
    public void createItemConnection(Order order, Item item) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.createItemConnection(order, item);
        }
    }

    @Override
    public List<Order> read(Long userId, Long orderId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            return orderRepository.read(userId, orderId);
        }
    }

    @Override
    public void update(Order order) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.update(order);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.delete(id);
        }
    }
}