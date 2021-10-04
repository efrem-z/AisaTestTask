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

    public Order create (String username, String serviceType, Date date){
        if(orderRepo.findByDate(date) !=null){
            return orderRepo.findByDate(date);
        } else {
            Order order = new Order(userRepo.findByUsername(username),serviceType,date);

            orderRepo.save(order);

            return order;
        }
    }

    public String timeToStart(long id){
        long currentDate =  System.currentTimeMillis();

        if(orderRepo.existsById(id)){
            Order order = orderRepo.findById(id);

            double a = ((order.getDate().getTime()-currentDate)/(60*60*1000));
            double b = ((order.getDate().getTime()-currentDate)/(60*1000));
            double c = b - a*60;

            return "start in " + a + " hours " + c + " minutes";
        } else {
            return null;
        }
    }

    public List<Order> showAll() {
        return orderRepo.findAll();
    }

    public Order findById(long id) {

        return orderRepo.findById(id);
    }

    public void removeById(long id) {
        orderRepo.deleteById(id);
    }
}
