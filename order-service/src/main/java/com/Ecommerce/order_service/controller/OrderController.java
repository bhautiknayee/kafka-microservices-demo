package com.Ecommerce.order_service.controller;

import com.Ecommerce.base_service.dto.Order;
import com.Ecommerce.base_service.dto.OrderEvent;
import com.Ecommerce.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrderStatus("PENDING");
        orderEvent.setMessage("Order Status is in pending state.");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "order placed successfully...";
    }

}
