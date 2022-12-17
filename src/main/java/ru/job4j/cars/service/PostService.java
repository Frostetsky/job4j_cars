package ru.job4j.cars.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.AddPostDto;
import ru.job4j.cars.dto.InfoCarDto;
import ru.job4j.cars.dto.PostInfoDto;
import ru.job4j.cars.dto.enums.SellStatus;
import ru.job4j.cars.mapper.PostMapper;
import ru.job4j.cars.repository.PostRepository;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final PostMapper postMapper;

    private final UserService userService;

    public List<PostInfoDto> getPostsByUser(long userId) {
        return postRepository.getPostsByUser(userId)
                .stream()
                .map(entity -> PostInfoDto.builder()
                        .id(entity.getId())
                        .created(entity.getCreated())
                        .mark(entity.getCar().getMark())
                        .model(entity.getCar().getModel())
                        .sellStatus(entity.getSellStatus())
                        .price(entity.getPrice())
                        .transmissionType(entity.getCar().getTransmissionType())
                        .build())
                .collect(Collectors.toList());
    }

    public List<PostInfoDto> getAllPosts() {
        return postRepository.getAllPosts()
                .stream()
                .map(postMapper::postEntityToPostInfoDto)
                .collect(Collectors.toList());
    }

    public List<PostInfoDto> getAllPostsByMark(String mark) {
        return postRepository.getPostsByMarkCar(mark)
                .stream()
                .map(postMapper::postEntityToPostInfoDto)
                .collect(Collectors.toList());
    }

    public void addPost(AddPostDto post, long userId) {
        var entityPost = postMapper.addPostDtoToEntityPost(post);
        var user = userService.getUserById(userId);
        entityPost.setUser(user);
        postRepository.savePost(entityPost);
    }

    public void update(Long postId, SellStatus sellStatus) {
        postRepository.updateStatus(postId, sellStatus);
    }

    public InfoCarDto getPostInfo(long postId) {
        var post = postRepository.getPostById(postId);
        return InfoCarDto.builder()
                .description(post.getDescription())
                .photoBase64(Base64.getEncoder().encodeToString(post.getPhoto()))
                .build();
    }
}
