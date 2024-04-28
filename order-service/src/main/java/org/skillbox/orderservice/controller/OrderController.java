package org.skillbox.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.skillbox.orderservice.mapper.OrderMapper;
import org.skillbox.orderservice.model.Order;
import org.skillbox.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> sendOrder(@RequestBody Order order){
        orderService.sendKafkaTopic(orderMapper.toOrderEvent(order));
        return ResponseEntity.ok().build();
    }
}
