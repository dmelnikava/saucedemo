package com.saucedemo.db.persistence;

import com.saucedemo.db.domain.Item;

import java.util.Optional;

public interface ItemRepository {

    void create(Item item);

    Optional<Item> read(Long id);

    void update(Item item);

    void delete(Long id);

}