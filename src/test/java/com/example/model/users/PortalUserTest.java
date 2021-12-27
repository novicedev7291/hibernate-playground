package com.example.model.users;

import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class PortalUserTest extends EntityManagerTest {

    @Test
    void shouldAddUserAndUserTypes() {
        doInTransaction(em -> {
            PortalUser user = new PortalUser();
            user.setId(1);

            UserType admin = new UserType("ADMIN");
            UserType support = new UserType("SUPPORT");
            UserType sales = new UserType("SALES");

            user.addAll(admin, support, sales);

            PortalUser supportUser = new PortalUser();
            supportUser.setId(2);
            supportUser.addAll(support);

            PortalUser salesUser = new PortalUser();
            salesUser.setId(3);
            salesUser.addAll(sales);

            List.of(user, supportUser, salesUser)
                .forEach(em::merge);
        });

        doInTransaction(em -> {
            PortalUser aUser = em.find(PortalUser.class, 2);

            assertThat(aUser).isNotNull();
            assertThat(aUser.getUserTypes())
                    .isNotEmpty().hasSize(1);
        });

    }

    @Test
    void shouldFetchTwoUsersForSalesType() {
        doInTransaction(em -> {
            PortalUser user = new PortalUser();
            user.setId(1);

            UserType admin = new UserType("ADMIN");
            UserType support = new UserType("SUPPORT");
            UserType sales = new UserType("SALES");

            user.addAll(admin, support, sales);

            PortalUser supportUser = new PortalUser();
            supportUser.setId(2);
            supportUser.addAll(support);

            PortalUser salesUser = new PortalUser();
            salesUser.setId(3);
            salesUser.addAll(sales);

            List.of(user, supportUser, salesUser)
                .forEach(em::merge);
        });

        doInTransaction(em -> {
            List<PortalUser> users = em.createQuery("Select u from PortalUser u left join fetch u.userTypes ut where ut.typeName = :name", PortalUser.class)
                                       .setParameter("name", "SALES")
                                       .getResultList();

            assertThat(users)
                    .isNotEmpty().hasSize(2);

            List<UserType> allTypes = em.createQuery("Select ut from UserType ut", UserType.class)
                                                          .getResultList();

            assertThat(allTypes)
                    .isNotEmpty().hasSize(3);
            assertThat(allTypes)
                    .extracting("typeName")
                    .containsExactlyInAnyOrder("ADMIN", "SUPPORT", "SALES");
        });

    }
}
