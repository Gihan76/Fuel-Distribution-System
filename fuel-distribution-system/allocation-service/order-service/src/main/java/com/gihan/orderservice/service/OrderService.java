package com.gihan.orderservice.service;

import com.gihan.orderservice.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getOrders();
    Order createOrder(Order order);
    ResponseEntity<Order> getOrderById(int id);
    ResponseEntity<Order> updateOrder(int id, Order orderDetails);
    ResponseEntity<Map<String, Boolean>> deleteOrder(int id);
}
