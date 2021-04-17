package com.example.model.course;

import com.example.model.profile.Profile;
import com.example.model.profile.UserDetail;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void shouldThrowErrorWhenUpdateDetachedParent() {
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

        Assertions.assertThrows(Exception.class, () -> {
           doInTransaction(em -> {
               Course course = em.find(Course.class, 1);
               course.setTitle("Hibernate Advanced Course");

               User user = new User();
               user.setName("Another Name");
               user.setEmail("def@xyz.com");

               course.setUser(user);
           });
        });
    }

    @Test
    void persistingUserWithProfile() {
        doInTransaction(em -> {
            UserDetail user = UserDetail.builder()
                                    .username("test")
                                    .password("test")
                                    .email("abc@xyz.com")
                                    .build();

            Profile profile = Profile.builder()
                                    .description("Nerd guy around you!!!")
                                    .build();
            user.setProfile(profile);

            em.persist(user);
        });

        doInTransaction( em -> {
            UserDetail user = em.find(UserDetail.class, 1);
            assertNotNull(user.getProfile().getIdProfile());
        });
    }

    @Test
    void lazyLoadingForOneToOneAttributeShouldWork() {
        doInTransaction(em -> {
            User user = new User();
            user.setEmail("abc@xyn.com");
            user.setName("Kuldeep Yadav");

            UserDetails userDetails = new UserDetails();
            userDetails.setId(1);
            userDetails.setBirthPlace("Bhiwani");

            user.setUserDetails(userDetails);
            userDetails.setUser(user);

            em.persist(user);
        });

        doInTransaction(em -> {
            User user = em.find(User.class, 1);

            UserDetails userDetails = user.getUserDetails();

            assertNotNull(userDetails);
            assertEquals(userDetails.getBirthPlace(), "Bhiwani");
        });
    }
}
