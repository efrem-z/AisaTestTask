package ru.ez.aisatesttask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.OrderType;

public interface OrderTypeRepo extends JpaRepository<OrderType, Long> {
    OrderType findByName(String name);
}
