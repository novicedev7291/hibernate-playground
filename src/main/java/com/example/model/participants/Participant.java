package com.example.model.participants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @Column(name="id")
    private Integer participantId;

    @OneToMany(mappedBy = "participant", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<GroupParticipant> groups = new ArrayList<>();

    public void addGroup(Group group) {
        GroupParticipant gP = new GroupParticipant(group, this);
        gP.setAdmin(false);
        groups.add(gP);
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getParticipantId() {
        return participantId;
    }
}
