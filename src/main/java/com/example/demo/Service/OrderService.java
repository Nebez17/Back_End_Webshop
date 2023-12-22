package com.example.demo.Service;

import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAllProducts(){
        return orderRepository.findAllOrdersOrderedByTime();
    }

    @Autowired
    public void OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }
}
