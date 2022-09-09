package com.gihan.orderservice.controller;

import com.gihan.orderservice.kafka.KafkaProducer;
import com.gihan.orderservice.model.Order;
import com.gihan.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200") // cross origin header to show data on browser api test
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    private KafkaProducer kafkaProducer;

    public OrderController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // get all orders
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    // create order request
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order){
        // return orderService.createOrder(order);

        orderService.createOrder(order);
//        int id = order.getId();
        kafkaProducer.sendMessage(order);
        return order;
    }

    // get order by Id
    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public ResponseEntity<Order> getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    // update order by Id
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order orderDetails){
        return orderService.updateOrder(id,orderDetails);
    }

    // delete request order
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Boolean>> deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }

}
