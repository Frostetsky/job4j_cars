package ru.job4j.cars.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoCarDto {

    private String description;

    private String photoBase64;
}
