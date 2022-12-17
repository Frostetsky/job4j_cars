package ru.job4j.cars.mapper;

import ru.job4j.cars.config.Mapper;
import ru.job4j.cars.dto.AddPostDto;
import ru.job4j.cars.dto.PostInfoDto;
import ru.job4j.cars.dto.enums.SellStatus;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;

@Mapper
public class PostMapper {

    public Post addPostDtoToEntityPost(AddPostDto postDto) {
        var post = new Post();
        var car = new Car();
        car.setMark(postDto.getMark());
        car.setModel(postDto.getModel());
        car.setTransmissionType(postDto.getTransmissionType());
        post.setCreated(LocalDateTime.now());
        post.setSellStatus(SellStatus.ON_SALE);
        post.setPhoto(postDto.getPhoto());
        post.setPrice(postDto.getPrice());
        post.setDescription(postDto.getDescription());
        post.setCar(car);
        return post;
    }

    public PostInfoDto postEntityToPostInfoDto(Post post) {
        return PostInfoDto.builder()
                .transmissionType(post.getCar().getTransmissionType())
                .sellStatus(post.getSellStatus())
                .model(post.getCar().getModel())
                .price(post.getPrice())
                .mark(post.getCar().getMark())
                .created(post.getCreated())
                .id(post.getId())
                .build();
    }
}
