package com.gihan.orderservice.service;

import com.gihan.orderservice.model.Order;
import com.gihan.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Order> getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("",orderRepository,"No order found"));
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<Order> updateOrder(int id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("",orderRepository,"No order found"));

        order.setName(orderDetails.getName());
        order.setAddress(orderDetails.getAddress());
        order.setCity(orderDetails.getCity());
        order.setZipCode(orderDetails.getZipCode());
        order.setFuelType(orderDetails.getFuelType());
        order.setCapacity(orderDetails.getCapacity());

        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteOrder(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("",orderRepository,"No order found"));
        orderRepository.delete(order);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
