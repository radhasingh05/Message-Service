package com.radha.publisher;

import com.radha.config.MessagingConfig;
import com.radha.dto.Order;
import com.radha.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOder(@RequestBody Order order,@PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,"IN-PROGRESS","order placed successfully in "+restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);
        return "Success !!";
    }
}
