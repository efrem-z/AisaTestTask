package ru.ez.aisatesttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ez.aisatesttask.domain.OrderType;
import ru.ez.aisatesttask.repo.OrderTypeRepo;

import java.util.List;

@Service
public class OrderTypeService {
    private final OrderTypeRepo orderTypeRepo;

    @Autowired
    public OrderTypeService(OrderTypeRepo orderTypeRepo) {
        this.orderTypeRepo = orderTypeRepo;
    }

    public List<OrderType> showAll(){
        return orderTypeRepo.findAll();
    }

    public void add (String typeOfOrder){
        OrderType orderType = new OrderType(typeOfOrder);

        orderTypeRepo.save(orderType);
    }

    public void delete (String typeOfOrder){
        orderTypeRepo.deleteByName(typeOfOrder);
    }
}
