package ru.cars.app.repository;

import ru.cars.app.persistence.Event;

public interface EventRepository {

    public void saveAll(Iterable<Event> event);
}
