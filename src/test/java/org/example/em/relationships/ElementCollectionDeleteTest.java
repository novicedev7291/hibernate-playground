package org.example.em.relationships;

import com.example.model.Board;
import com.example.model.Topic;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class ElementCollectionDeleteTest extends EntityManagerTest {
    @Test
    void shouldDeleteOneOutOfElementCollection() {
        doInTransaction(em -> {
            Board board = new Board(1, "OOPS hibernate and JPA");

            board.addTopic(new Topic("Good article!!!"));
            board.addTopic(new Topic("Little long but thoughtful"));
            board.addTopic(new Topic("Loved the way you explained"));

            em.persist(board);
        });

        doInTransaction( em -> {
            Board board = em.find(Board.class, 1);

            List<Topic> comments = board.getTopics();

            comments.remove(2);
        });
    }
}
