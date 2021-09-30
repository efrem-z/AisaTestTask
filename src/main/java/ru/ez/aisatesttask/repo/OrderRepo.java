package ru.ez.aisatesttask.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
}
