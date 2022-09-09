package com.gihan.orderservice.kafka;

import com.gihan.orderservice.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, Order> kafkaTemplate;

//    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Order> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void sendMessage(Order orderDetails){
        LOGGER.info(String.format("New Order Request Sent -> %s",orderDetails.toString()));

        Message<Order> message = MessageBuilder
                .withPayload(orderDetails)
                .setHeader(KafkaHeaders.TOPIC,"ordertopic")
                .build();

        kafkaTemplate.send(message);
    }

//    public void sendMessage(String message){
//        LOGGER.info(String.format("Message sent %s", message));
//        kafkaTemplate.send("ordertopic",message);
//    }




}
