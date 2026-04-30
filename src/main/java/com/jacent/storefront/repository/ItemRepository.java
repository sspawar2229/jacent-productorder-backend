package com.jacent.storefront.repository;

import com.jacent.storefront.query.ItemQueries;
import com.jacent.storefront.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ItemQueries itemQueries;

    public List<Item> getAllItemsPagination(int page, int size) {
        int offset = page * size;

        return jdbcTemplate.query(
                itemQueries.getAllItems(),
                new Object[]{size, offset},
                new BeanPropertyRowMapper<>(Item.class)
        );
    }

    public int getTotalItemsCount() {
        return jdbcTemplate.queryForObject(itemQueries.getItemCount(), Integer.class);
    }
}
