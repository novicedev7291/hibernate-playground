package com.example.model.participants;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "t_group_participants")
public class GroupParticipant {
    @EmbeddedId
    private ParticipantId id;

    @ManyToOne
    @MapsId("groupId")
    private Group group;
    @ManyToOne
    @MapsId("participantId")
    private Participant participant;
    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public GroupParticipant() { }

    public GroupParticipant(Group group, Participant participant) {
        this.group = group;
        this.participant = participant;
        this.id = new ParticipantId(group.getId(), participant.getParticipantId());
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
