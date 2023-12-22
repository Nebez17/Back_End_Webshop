package com.example.demo.Controller;

import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Service.OrderService;
import com.example.demo.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<Order> addProduct(@Valid @RequestBody Order order) {
        Order newOrder = orderService.addOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllProducts(){
        List<Order> orders = orderService.findAllProducts();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
