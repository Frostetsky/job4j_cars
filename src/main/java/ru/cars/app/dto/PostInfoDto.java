package ru.cars.app.dto;

import lombok.*;
import ru.cars.app.dto.enums.SellStatus;
import ru.cars.app.dto.enums.TransmissionType;

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
