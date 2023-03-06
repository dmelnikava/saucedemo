package com.saucedemo.db.service;

import com.saucedemo.db.domain.Item;

public interface ItemService {

    Item create(Item item);

    Item read(Long id);

    void update(Item item);

    void delete(Long id);

}