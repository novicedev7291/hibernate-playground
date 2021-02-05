package org.example.em.relationships;

import com.example.model.Post;
import com.example.model.PostComment;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class OneToManyTest extends EntityManagerTest {
    @Test
    void shouldAddCommentsToPostUsingJoinColumn() {
        doInTransaction(em -> {
            Post post = new Post(1,"One to many relationship using Join Column");

            PostComment comment1 = new PostComment(1,"Awesome article");
            PostComment comment2 = new PostComment(2,"Wonderful article but little overwhelming");

            post.addComment(comment1);
            post.addComment(comment2);

            em.persist(post);
        });
    }

    @Test
    void shouldDeleteOneCommentOfAPost() {
        doInTransaction(em -> {
            Post post = new Post(1, "One to many relationship using Join Column");

            PostComment comment1 = new PostComment(1, "Awesome article");
            PostComment comment2 = new PostComment(2,"Wonderful article but little overwhelming");

            post.addComment(comment1);
            post.addComment(comment2);

            em.persist(post);
        });

        doInTransaction(em -> {
            Post post = em.find(Post.class, 1);

            post.getComments().remove(1);
        });
    }
}
