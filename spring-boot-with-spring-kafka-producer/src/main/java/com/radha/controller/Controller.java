package com.radha.controller;

import com.radha.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class Controller {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
   // private KafkaTemplate<String,String> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
         //kafkaTemplate.send(TOPIC,message);
         kafkaTemplate.send(TOPIC,new User(name,"IT",10000L));
         return "Message Successfully published !";
    }


}
