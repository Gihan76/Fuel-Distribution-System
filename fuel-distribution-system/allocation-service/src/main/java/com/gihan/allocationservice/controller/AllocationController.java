package com.gihan.allocationservice.controller;

import com.gihan.allocationservice.model.Allocation;
import com.gihan.allocationservice.service.AllocationService;
import com.gihan.orderservice.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AllocationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationController.class);
    @Autowired
    AllocationService allocationService;

    private KafkaTemplate<String, String> scheduleKafkaTemplate;

    public AllocationController(KafkaTemplate<String, String> scheduleKafkaTemplate) {
        this.scheduleKafkaTemplate = scheduleKafkaTemplate;
    }

    @KafkaListener(topics = "ordertopic",groupId = "fuelOrderGroup")
    public void listener(Order order){
        LOGGER.info(String.format("New Order Received -> %s", order.toString()));

        Allocation allocation = allocationService.makeAllocation(order.getId(),order.getCapacity(),order.getFuelType());
        if (allocation == null) {
            String message  = "Fuel allocation failed for order number "+order.getId();
            LOGGER.info(String.format("Allocation Failed -> %s", message));
            scheduleKafkaTemplate.send("schedulefail",message);
        } else {
            String message  = "Fuel allocated for order number "+order.getId();
            LOGGER.info(String.format("Allocation Success -> %s", message));
            scheduleKafkaTemplate.send("scheduletopic",message);
        }

    }

}
