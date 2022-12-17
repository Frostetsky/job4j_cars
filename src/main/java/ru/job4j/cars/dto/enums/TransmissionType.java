package ru.job4j.cars.dto.enums;

import lombok.Getter;

public enum TransmissionType {
    AUTOMATIC("Автоматическая коробка передач"),
    MECHANIC("Механическая коробка передач");

    @Getter
    private final String named;

    TransmissionType(String named) {
        this.named = named;
    }
}