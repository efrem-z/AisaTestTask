package ru.ez.aisatesttask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
