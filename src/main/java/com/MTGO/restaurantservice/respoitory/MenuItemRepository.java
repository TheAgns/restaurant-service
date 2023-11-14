package com.MTGO.restaurantservice.respoitory;

import com.MTGO.restaurantservice.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}
