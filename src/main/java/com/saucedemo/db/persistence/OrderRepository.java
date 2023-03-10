package com.saucedemo.db.persistence;

import com.saucedemo.db.domain.Item;
import com.saucedemo.db.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void create(@Param("userId") Long userId, @Param("order") Order order);

    void createItemConnection(Order order, Item item);

    List<Order> read(@Param("userId") Long userId, @Param("orderId") Long orderId);

    void update(Order order);

    void delete(Long id);

}