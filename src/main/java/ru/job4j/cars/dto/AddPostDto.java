package ru.job4j.cars.dto;

import lombok.*;
import ru.job4j.cars.dto.enums.SellStatus;
import ru.job4j.cars.dto.enums.TransmissionType;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPostDto {

    private String model;

    private String mark;

    private TransmissionType transmissionType;

    private String price;

    private String description;

    private byte[] photo;

    private LocalDateTime created;

    private SellStatus sellStatus;
}
