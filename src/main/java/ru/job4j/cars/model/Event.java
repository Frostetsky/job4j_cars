package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "events")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "mark")
    private String mark;

    @Column(name = "transmission_type")
    private String transmissionType;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Column(name = "username")
    private String username;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "price")
    private String price;
}
