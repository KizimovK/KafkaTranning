package org.skillbox.orderservice.model;

import lombok.Data;

@Data
public class Order {
    private String product;
    private Integer quantity;

}
