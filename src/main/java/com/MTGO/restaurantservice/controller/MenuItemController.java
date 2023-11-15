package com.MTGO.restaurantservice.controller;


import com.MTGO.restaurantservice.dto.MenuItemRequest;
import com.MTGO.restaurantservice.dto.MenuItemResponse;
import com.MTGO.restaurantservice.model.MenuItem;
import com.MTGO.restaurantservice.service.MenuItemService;
import com.MTGO.restaurantservice.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menuItem")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

//    @Autowired
//    private MenuItem menuItem;
//
//    @Autowired
//    private SequenceGeneratorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody MenuItemRequest menuItemRequest){
        //menuItem.setId(service.getSequenceNumber(MenuItem.SEQUENCE_NAME));
        menuItemService.createMenuItem(menuItemRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MenuItemResponse> getAllMenuItems(){
        return menuItemService.getAllMenuItems();
    }
}
