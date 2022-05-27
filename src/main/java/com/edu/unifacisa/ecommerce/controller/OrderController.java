package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.Order;
import com.edu.unifacisa.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll () {
        return orderService.findAll();
    }

    @PostMapping("/insert")
    public void insertOrder (@RequestBody Order order) {
        orderService.insertOrder(order);
    }



}
