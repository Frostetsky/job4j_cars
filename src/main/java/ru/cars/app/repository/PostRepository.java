package ru.cars.app.repository;

import ru.cars.app.dto.enums.SellStatus;
import ru.cars.app.persistence.Post;

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
