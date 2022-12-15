package ru.cars.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.cars.app.persistence.Event;
import ru.cars.app.persistence.Post;
import ru.cars.app.repository.EventRepository;
import ru.cars.app.repository.PostRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final PostRepository postRepository;
    private final EventRepository eventRepository;

    @Scheduled(cron = "${job.event.cron}")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearSellAutoAndWriteToEventStore() {
        var posts = postRepository.getSalesCars();
        eventRepository.saveAll(getListEvents(posts));
        postRepository.deletePosts(posts);
        log.info("Выполнена задача по очистке проданных автомобилей. Все продажи добавлены в историю.");
    }

    private List<Event> getListEvents(List<Post> posts) {
        return posts.stream()
                .map(post -> Event.builder()
                        .sellDate(LocalDate.now())
                        .mark(post.getCar().getMark())
                        .model(post.getCar().getModel())
                        .price(post.getPrice())
                        .transmissionType(post.getCar().getTransmissionType().getNamed())
                        .photo(post.getPhoto())
                        .username(post.getUser().getUsername())
                        .build())
                .collect(Collectors.toList());
    }
}
