package com.radha.consumer;

import com.radha.config.MessagingConfig;
import com.radha.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) throws InterruptedException {
        System.out.println("Message received from queue : " + orderStatus);
    }
}

