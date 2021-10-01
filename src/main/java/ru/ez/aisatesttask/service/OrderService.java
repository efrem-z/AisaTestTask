package ru.ez.aisatesttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ez.aisatesttask.domain.Order;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.repo.OrderRepo;
import ru.ez.aisatesttask.repo.UserRepo;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    private final UserRepo userRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    public Order create (User client, String serviceType, Date date){
        if(orderRepo.existByDate(date)){
            return orderRepo.findByDate(date);
        } else {
            Order order = new Order(client,serviceType,date);

            orderRepo.save(order);

            return order;
        }
    }

    public Long timeToStart(long id){
        long currentDate =  System.currentTimeMillis();

        if(orderRepo.existsById(id)){
            Order order = orderRepo.findById(id).get();

            long hoursToStart = (order.getDate().getTime()-currentDate)/(60*60*1000);

            return hoursToStart;
        } else {
            return null;
        }
    }

    public List<Order> showAll() {
        return orderRepo.findAll();
    }

    public Order findById(long id) {
        Order order = null;
        if (orderRepo.findById(id).isPresent()) {
            order = orderRepo.findById(id).get();
        }
        return order;
    }

    public void removeById(long id) {
        orderRepo.deleteById(id);
    }
}
