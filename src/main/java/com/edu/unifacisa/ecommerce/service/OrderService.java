package com.edu.unifacisa.ecommerce.service;

import com.edu.unifacisa.ecommerce.model.Order;
import com.edu.unifacisa.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll () {
        return orderRepository.findAll();
    }

    public void insertOrder (Order order) {
        orderRepository.save(order);
    }

}
