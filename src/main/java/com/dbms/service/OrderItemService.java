package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.model.OrderItem;
import com.dbms.inventorysystem.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Integer id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }
}