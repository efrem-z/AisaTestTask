package ru.ez.aisatesttask.ServiceTests;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.ez.aisatesttask.domain.Role;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.repo.UserRepo;
import ru.ez.aisatesttask.service.UserService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void addUser() {
        User user = new User();

        user.setEmail("some@mail.ru");

        boolean isUserCreated = userService.addUser(user);

        assertTrue(isUserCreated);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.CLIENT)));

        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }

    @Test
    public void addUserFailTest() {
        User user = new User();

        user.setUsername("John");

        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("John");

        boolean isUserCreated = userService.addUser(user);

        assertFalse(isUserCreated);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }

}
