package ru.job4j.cars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.job4j.cars.dto.enums.SellStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@NamedEntityGraphs(value = {
        @NamedEntityGraph(
                name = "post-entity-graph-info",
                attributeNodes = {
                        @NamedAttributeNode("description"),
                        @NamedAttributeNode("photo"),
                }
        ),
        @NamedEntityGraph(
                name = "post-entity-graph-event",
                attributeNodes = {
                        @NamedAttributeNode("photo"),
                        @NamedAttributeNode("user")
                }
        )
})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "description")
    @Basic(fetch = FetchType.LAZY)
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "photo")
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "sell_status")
    @Enumerated(EnumType.STRING)
    private SellStatus sellStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
