package ru.ez.aisatesttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.ez.aisatesttask.domain.Role;
import ru.ez.aisatesttask.domain.User;
import ru.ez.aisatesttask.repo.UserRepo;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userRepo;


    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return user;
    }

    public User addUser(User user) {
        User userFromDb = userRepo.findById(user.getId());

        if (userFromDb != null) {
            return userFromDb;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.CLIENT));
        user.setPassword(user.getPassword());

        userRepo.save(user);

        return user;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }


    public void updateProfile(User user, String password, String email) {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(email);
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        userRepo.save(user);
    }

    public User findById(long id){
        return userRepo.findById(id);
    }
}
