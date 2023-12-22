package com.example.demo.Repository;

import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT e FROM Order e ORDER BY e.time")
    List<Order> findAllOrdersOrderedByTime();

}
