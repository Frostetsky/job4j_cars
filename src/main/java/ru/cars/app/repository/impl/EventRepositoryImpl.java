package ru.cars.app.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.cars.app.persistence.Event;
import ru.cars.app.repository.EventRepository;


@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveAll(Iterable<Event> event) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            event.forEach(session::save);
            session.getTransaction().commit();
        }
    }
}
