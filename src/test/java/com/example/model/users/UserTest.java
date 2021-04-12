package com.example.model.users;

import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest extends EntityManagerTest {
    @Test
    void shouldPersistUserWithRoleAndRoleId() {
        doInTransaction(em -> {
            User aUser = new User("Kuldeep");

            RoleId roleViewId = new RoleId("AUTH_VIEW");
            Role aViewRole = new Role();
            aViewRole.setId(roleViewId);

            RoleId roleWriteId = new RoleId("AUTH_WRITE");
            Role aWriteRole = new Role();
            aWriteRole.setId(roleWriteId);

            aUser.add(aViewRole);
            aUser.add(aWriteRole);

            em.persist(aUser);
        });

        doInTransaction(em -> {
            User aUser = em.find(User.class, 1);

            List<Role> roles = aUser.getRoles();

            assertNotNull(roles);
            assertEquals(roles.size(), 2);

            assertEquals(roles.get(0).getId().getUserId(), aUser.getId());
            assertEquals(roles.get(1).getId().getUserId(), aUser.getId());

            RoleId roleViewId = new RoleId("AUTH_UPDATE");
            Role aUpdateRole = new Role();
            aUpdateRole.setId(roleViewId);

            aUpdateRole.setUser(aUser);

            em.persist(aUpdateRole);

        });
    }

    @Test
    void shouldUpdateRolesWithExistingUser() {

    }
}
