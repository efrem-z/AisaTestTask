package ru.ez.aisatesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ez.aisatesttask.domain.Order;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.service.OrderService;
import ru.ez.aisatesttask.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService,UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createOrder(
            @RequestParam String username,
            @RequestParam String serviceType,
            @RequestParam Date date){
       orderService.create(username, serviceType, date);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id){
        return orderService.findById(id);
    }

    @GetMapping("/time/{order_id}")
    public String getTimeBeforeStart(@PathVariable long order_id){
        return orderService.timeToStart(order_id);
    }

    @GetMapping("all/{user_id}")
    public List<Order> getAllOrders(
        @PathVariable long user_id){
        return userService.findById(user_id).getOrders();
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all-orders")
    public List<Order> getAllClientsOrders(){
        return orderService.showAll();
    }
}
