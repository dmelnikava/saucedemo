package com.saucedemo.db.service.impl;

import com.saucedemo.db.domain.Item;
import com.saucedemo.db.domain.exception.QueryException;
import com.saucedemo.db.persistence.ItemRepository;
import com.saucedemo.db.persistence.impl.ItemMapperImpl;
import com.saucedemo.db.service.ItemService;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl() {
        this.itemRepository = new ItemMapperImpl();
    }

    @Override
    public Item create(Item item) {
        item.setId(null);
        itemRepository.create(item);
        return item;
    }

    @Override
    public Item read(Long id) {
        return itemRepository.read(id)
                .orElseThrow(() -> new QueryException("No items found"));
    }

    @Override
    public void update(Item item) {
        itemRepository.update(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }
}
