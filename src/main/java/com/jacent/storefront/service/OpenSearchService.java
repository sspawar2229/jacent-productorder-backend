package com.jacent.storefront.service;

import com.jacent.storefront.entity.Item;

import java.io.IOException;
import java.util.List;

public interface OpenSearchService {

    void bulkIndexProducts(List<Item> items) throws IOException;

    List<Item> searchItems(String searchString) throws IOException;
}
