package com.example.model.battle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class BattleGroupVillageId implements Serializable {
    private static final long serialVersionUID = -6375405007868923427L;

    @Column(name = "battle_group_id")
    private UUID battleGroupId;

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "village_id")
    private Integer villageId;

    public BattleGroupVillageId(UUID battleGroupId, Integer playerId, Integer villageId) {
        this.battleGroupId = battleGroupId;
        this.villageId = villageId;
        this.playerId = playerId;
    }
}
