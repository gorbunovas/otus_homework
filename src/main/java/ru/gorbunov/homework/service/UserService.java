package ru.gorbunov.homework.service;


import ru.gorbunov.homework.entity.UserEntity;
import ru.gorbunov.homework.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(UserEntity user);

    User getUserById(Long id);

    User updateUser(Long id, UserEntity newUser);

    void deleteUser(Long id);
}
