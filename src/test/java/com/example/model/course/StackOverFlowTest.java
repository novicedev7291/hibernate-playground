package com.example.model.course;

import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;

class StackOverFlowTest extends EntityManagerTest {
    @Test
    void persistingCoursesWithUserShouldWork() {
        doInTransaction( em -> {
            User user = new User();
            user.setName("Kuldeep");
            user.setEmail("kuldeepyadav7291@gmail.com");

            String[] courses = new String[]{"Hibernate Course", "Spring JPA Course"};

            asList(courses).forEach(s -> {
                Course course = new Course();
                course.setTitle(s);
                user.add(course);
            });

            em.persist(user);
        });

        doInTransaction(em -> {
            User user = em.find(User.class, 1);
            Assertions.assertEquals(user.getCourses().size(), 2);
        });
    }
}
