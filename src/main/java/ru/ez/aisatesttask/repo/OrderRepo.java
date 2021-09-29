package ru.ez.aisatesttask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
