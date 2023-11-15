package com.MTGO.restaurantservice.service;

import com.MTGO.restaurantservice.dto.MenuItemRequest;
import com.MTGO.restaurantservice.dto.MenuItemResponse;
import com.MTGO.restaurantservice.model.MenuItem;
import com.MTGO.restaurantservice.respoitory.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor //laver vores menuitemrespoity construtor når man compiler
@Slf4j // vores logging
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    public void createMenuItem(MenuItemRequest menuItemRequest){
        MenuItem menuItem = MenuItem.builder()
                .name(menuItemRequest.getName())
                .description(menuItemRequest.getDescription())
                .price(menuItemRequest.getPrice())
                .build();
        menuItemRepository.save(menuItem);
        log.info("Menu item {} is saved", menuItem.getId());

    }

    public List<MenuItemResponse> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();

        return menuItems.stream().map(this::mapToMenuItemResponse).toList();

    }

    private MenuItemResponse mapToMenuItemResponse(MenuItem menuItem){
        return MenuItemResponse.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .build();
    }
}
