package ru.job4j.cars.repository;

import ru.job4j.cars.model.User;

public interface UserRepository {

    User findByUsername(String username);

    User findById(long id);

    void save(User user);
}
