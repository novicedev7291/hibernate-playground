package com.example.model.participants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipantId implements Serializable {
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "participant_id")
    private Integer participantId;

    public ParticipantId() {}

    public ParticipantId(Integer groupId, Integer participantId) {
        this.groupId = groupId;
        this.participantId = participantId;
    }
}
