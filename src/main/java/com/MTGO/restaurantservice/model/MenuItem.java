package com.MTGO.restaurantservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(value = "menu_item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class MenuItem {
    @Id
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
