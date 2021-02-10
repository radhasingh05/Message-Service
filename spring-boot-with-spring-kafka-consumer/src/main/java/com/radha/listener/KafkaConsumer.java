package com.radha.listener;

import com.radha.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 *
 * the Application is listening from 2 different topics Kafka_Example and Kafka_Example_Json
 *
 */

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example",groupId = "group_id")
    public void consume(String message){
        System.out.println("consumed message is : "+ message);
    }

    @KafkaListener(topics = "Kafka_Example_Json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }

}
