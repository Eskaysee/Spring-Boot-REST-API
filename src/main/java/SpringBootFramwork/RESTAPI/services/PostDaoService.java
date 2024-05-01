package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();
    private static int postCOunt = 0;

    static {
        posts.add(new Post(++postCOunt, "This is my first post"));
        posts.add(new Post(++postCOunt, "Second Post"));
        posts.add(new Post(++postCOunt, "This is my third post"));
    }

    public static List<Post> findAll() {
        return posts;
    }

    public Post findById(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public void savePost(Post post) {
        post.setId(++postCOunt);
        posts.add(post);
    }

    public  boolean deleteById(int id) {
        return posts.removeIf(post -> post.getId() == id);
    }
}
