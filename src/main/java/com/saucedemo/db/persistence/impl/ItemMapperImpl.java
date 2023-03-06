package com.saucedemo.db.persistence.impl;

import com.saucedemo.db.domain.Item;
import com.saucedemo.db.persistence.ItemRepository;
import com.saucedemo.db.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class ItemMapperImpl implements ItemRepository {

    @Override
    public void create(Item item) {
        try(SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            ItemRepository itemRepository = sqlSession.getMapper(ItemRepository.class);
            itemRepository.create(item);
        }
    }

    @Override
    public Optional<Item> read(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            ItemRepository itemRepository = sqlSession.getMapper(ItemRepository.class);
            return itemRepository.read(id);
        }
    }

    @Override
    public void update(Item item) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            ItemRepository itemRepository = sqlSession.getMapper(ItemRepository.class);
            itemRepository.update(item);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            ItemRepository itemRepository = sqlSession.getMapper(ItemRepository.class);
            itemRepository.delete(id);
        }
    }
}