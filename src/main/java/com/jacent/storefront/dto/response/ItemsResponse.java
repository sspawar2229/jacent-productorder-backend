package com.jacent.storefront.dto.response;

import com.jacent.storefront.entity.Item;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ItemsResponse {
    private List<Item> content;
    private int pageNo;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
}
