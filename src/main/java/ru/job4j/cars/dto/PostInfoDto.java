package ru.job4j.cars.dto;

import lombok.*;
import ru.job4j.cars.dto.enums.SellStatus;
import ru.job4j.cars.dto.enums.TransmissionType;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostInfoDto {

    private long id = -1L;

    private String model;

    private String mark;

    private TransmissionType transmissionType;

    private String price;

    private LocalDateTime created;

    private SellStatus sellStatus;
}
