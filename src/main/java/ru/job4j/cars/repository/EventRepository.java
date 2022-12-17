package ru.job4j.cars.repository;

import ru.job4j.cars.model.Event;

public interface EventRepository {

    public void saveAll(Iterable<Event> event);
}
