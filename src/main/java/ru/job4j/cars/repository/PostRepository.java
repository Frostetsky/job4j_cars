package ru.job4j.cars.repository;

import ru.job4j.cars.dto.enums.SellStatus;
import ru.job4j.cars.model.Post;

import java.util.List;

public interface PostRepository {

    public List<Post> getPostsByUser(long userId);

    public List<Post> getAllPosts();

    public void savePost(Post post);

    public void updateStatus(long postId, SellStatus sellStatus);

    public Post getPostById(long postId);

    public List<Post> getSalesCars();

    public List<Post> getPostsByMarkCar(String mark);

    public void deletePosts(Iterable<Post> posts);
}
