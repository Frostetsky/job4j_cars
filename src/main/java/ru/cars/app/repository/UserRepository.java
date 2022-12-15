package ru.cars.app.repository;

import ru.cars.app.persistence.User;

public interface UserRepository {

    User findByUsername(String username);

    User findById(long id);

    void save(User user);
}
