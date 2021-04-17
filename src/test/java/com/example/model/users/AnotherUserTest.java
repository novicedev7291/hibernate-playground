package com.example.model.users;

import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnotherUserTest extends EntityManagerTest {
    @Test
    void shouldPersistUserWithRoleAndRoleId() {
        doInTransaction(em -> {
            AnotherUser aAnotherUser = new AnotherUser("Kuldeep");

            RoleId roleViewId = new RoleId("AUTH_VIEW");
            Role aViewRole = new Role();
            aViewRole.setId(roleViewId);

            RoleId roleWriteId = new RoleId("AUTH_WRITE");
            Role aWriteRole = new Role();
            aWriteRole.setId(roleWriteId);

            aAnotherUser.add(aViewRole);
            aAnotherUser.add(aWriteRole);

            em.persist(aAnotherUser);
        });

        doInTransaction(em -> {
            AnotherUser aAnotherUser = em.find(AnotherUser.class, 1);

            List<Role> roles = aAnotherUser.getRoles();

            assertNotNull(roles);
            assertEquals(roles.size(), 2);

            assertEquals(roles.get(0).getId().getUserId(), aAnotherUser.getId());
            assertEquals(roles.get(1).getId().getUserId(), aAnotherUser.getId());

            RoleId roleViewId = new RoleId("AUTH_UPDATE");
            Role aUpdateRole = new Role();
            aUpdateRole.setId(roleViewId);

            aUpdateRole.setAnotherUser(aAnotherUser);

            em.persist(aUpdateRole);

        });
    }

    @Test
    void shouldUpdateRolesWithExistingUser() {

    }
}
