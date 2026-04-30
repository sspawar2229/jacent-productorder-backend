package com.jacent.storefront.service.impl;

import com.jacent.storefront.dto.response.ItemsResponse;
import com.jacent.storefront.entity.Commodity;
import com.jacent.storefront.entity.Configuration;
import com.jacent.storefront.entity.Division;
import com.jacent.storefront.entity.Item;
import com.jacent.storefront.repository.CommodityRepository;
import com.jacent.storefront.repository.DivisionRepository;
import com.jacent.storefront.repository.ItemRepository;
import com.jacent.storefront.service.ConfigurationService;
import com.jacent.storefront.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final ConfigurationService configurationService;
    private final ItemRepository itemRepository;
    private final DivisionRepository divisionRepository;
    private final CommodityRepository commodityRepository;

    ItemServiceImpl(ItemRepository itemRepository, ConfigurationService configurationService, DivisionRepository divisionRepository, CommodityRepository commodityRepository) {
        this.itemRepository = itemRepository;
        this.configurationService = configurationService;
        this.divisionRepository = divisionRepository;
        this.commodityRepository = commodityRepository;
    }

    @Override
    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Commodity> getAllCommodities() {
        return commodityRepository.findAll();
    }

    @Override
    public ItemsResponse getItems(Integer pageNo, Integer pageSize) {
        if(pageSize == null){
            pageSize = configurationService.getValueAsInteger(Configuration.PAGINATION_SIZE, 25);
        }

        long total = itemRepository.getTotalItemsCount();

        List<Item> itemList = itemRepository.getAllItemsPagination(pageNo, pageSize);

        return ItemsResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .content(itemList)
                .totalElements(total)
                .totalPages((int) Math.ceil((double) total / pageSize))
                .build();
    }
}
