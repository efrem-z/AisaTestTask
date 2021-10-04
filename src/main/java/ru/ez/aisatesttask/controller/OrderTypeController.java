package ru.ez.aisatesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ez.aisatesttask.domain.OrderType;
import ru.ez.aisatesttask.service.OrderTypeService;

import java.util.List;

@RestController
@RequestMapping("/types")
public class OrderTypeController {
    private final OrderTypeService orderTypeService;

    @Autowired
    public OrderTypeController(OrderTypeService orderTypeService) {
        this.orderTypeService = orderTypeService;
    }

    @GetMapping()
    public List<OrderType> getAllServiceTypes(){
        return orderTypeService.showAll();
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public void addNewType(@RequestParam String name){
        orderTypeService.add(name);
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public void deleteOldTypes(@RequestParam String name){
        orderTypeService.delete(name);
    }
}
