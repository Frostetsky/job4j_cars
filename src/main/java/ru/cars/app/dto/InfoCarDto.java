package ru.cars.app.dto;

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
