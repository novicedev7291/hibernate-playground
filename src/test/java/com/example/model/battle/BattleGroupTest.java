package com.example.model.battle;

import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BattleGroupTest extends EntityManagerTest {
    @Test
    void shouldCreateBattleGroupEntity() {
        UUID battleGroupId = UUID.randomUUID();

        doInTransaction( em -> {
            BattleGroupPlayer player = new BattleGroupPlayer(UUID.randomUUID(), battleGroupId, 1);

            BattleGroupVillageId villageId1 = new BattleGroupVillageId(
                    battleGroupId,
                    1,
                    1
            );
            BattleGroupVillageId villageId2 = new BattleGroupVillageId(
                    battleGroupId,
                    1,
                    2
            );

            BattleGroupVillage village1 = new BattleGroupVillage(villageId1, "Village 1");
            BattleGroupVillage village2 = new BattleGroupVillage(villageId2, "Village 2");

            player.addVillage(village1);
            player.addVillage(village2);

            BattleGroup battleGroup = new BattleGroup(battleGroupId, "Takeshi Castle");
            battleGroup.addPlayer(player);

            em.persist(battleGroup);

        });

        doInTransaction( em -> {
            BattleGroup battleGroup = em.find(BattleGroup.class, battleGroupId);

            assertNotNull(battleGroup);
            assertEquals(1, battleGroup.getPlayers().size());

            BattleGroupPlayer player = battleGroup.getPlayers().get(0);
            assertEquals(2, player.getVillages().size());
        });
    }

}