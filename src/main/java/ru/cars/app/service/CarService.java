package ru.cars.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cars.app.repository.CarRepository;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
}
