package ru.ez.aisatesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ez.aisatesttask.service.OrderTypeService;

@Controller
@RequestMapping("/types")
public class OrderTypeController {
    private final OrderTypeService orderTypeService;

    @Autowired
    public OrderTypeController(OrderTypeService orderTypeService) {
        this.orderTypeService = orderTypeService;
    }

    @GetMapping()
    public String serviceTypes(Model model){
        model.addAttribute("service-types", orderTypeService.showAll());

        return "service-types";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public String addNewType(@RequestParam String name){
        orderTypeService.add(name);

        return "service-types";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteOldTypes(@RequestParam String name){
        orderTypeService.delete(name);

        return "service-types";
    }
}
