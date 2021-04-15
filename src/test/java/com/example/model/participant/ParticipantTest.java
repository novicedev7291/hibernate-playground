package com.example.model.participant;

import com.example.model.participants.Group;
import com.example.model.participants.Participant;
import com.example.model.participants.ParticipantId;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParticipantTest extends EntityManagerTest {

    @Test
    void shouldAddParticipantsToExistingGroup() {
        doInTransaction(em -> {
            Group g = new Group();
            em.persist(g);
        });

        doInTransaction(em -> {
            Group g = em.find(Group.class, 1);


            Participant p = new Participant();
            p.setParticipantId(1);

            List<Participant> participants = new ArrayList<>(1);
            participants.add(p);

            g.setParticipants(participants);
        });
    }
}
