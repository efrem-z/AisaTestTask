package ru.ez.aisatesttask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ez.aisatesttask.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
