package ru.ez.aisatesttask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.ReservationTime;

public interface ReservationTimeRepo extends JpaRepository<ReservationTime, Long> {
}
