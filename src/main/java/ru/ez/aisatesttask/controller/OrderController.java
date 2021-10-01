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

import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public String createOrder(
            @AuthenticationPrincipal User client,
            @RequestParam String serviceType,
            @RequestParam Date date){
       orderService.create(client, serviceType, date);

        return "redirect:/orders";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable long id, Model model){
        model.addAttribute("order",orderService.findById(id));

        return "order";
    }

    @GetMapping("/time/{id}")
    public String getTimeBeforeStart(@PathVariable long id, Model model){
        model.addAttribute("timeBeforeStart", orderService.timeToStart(id));

        return "time-before-start";
    }

    @GetMapping("/{user}")
    public String getAllOrders(
        @AuthenticationPrincipal User currentClient,
        @PathVariable User user,
        Model model){
        Set<Order> orders = user.getOrders();

        model.addAttribute("orders",orders);
        model.addAttribute("isCurrentUser",currentClient.equals(user));

        return "my-orders";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all-orders")
    public String getAllClientsOrders(Model model){
        model.addAttribute(orderService.showAll());

        return "clients-orders";
    }





}
