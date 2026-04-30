package com.jacent.storefront.controller;

import com.jacent.storefront.dto.response.ItemsResponse;
import com.jacent.storefront.entity.Commodity;
import com.jacent.storefront.entity.Division;
import com.jacent.storefront.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ItemController {

    ItemService itemService;

    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/divisions")
    public ResponseEntity<List<Division>> getAllDivisions() {
        return ResponseEntity.ok(itemService.getAllDivisions());
    }

    @GetMapping("/commodities")
    public ResponseEntity<List<Commodity>> getAllCommodities() {
        return ResponseEntity.ok(itemService.getAllCommodities());
    }

    @GetMapping("/items")
    public ResponseEntity<ItemsResponse> getItems(@RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(required = false) Integer pageSize) {
        return ResponseEntity.ok(itemService.getItems(pageNo, pageSize));
    }
}
