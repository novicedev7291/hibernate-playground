package com.example.model.battle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@NoArgsConstructor
@Table(name = "battle_group_player")
public class BattleGroupPlayer implements Serializable {
    private static final long serialVersionUID = -496344760011840496L;

    @Id
    private UUID id;

    @Column(name = "battle_group_id")
    private UUID battleGroupId;

    @Column(name = "player_id")
    private Integer playerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumns({
                    @JoinColumn(name = "player_id", referencedColumnName = "player_id"),
                    @JoinColumn(name = "battle_group_id", referencedColumnName = "battle_group_id")
            }
    )
    private Set<BattleGroupVillage> villages = new HashSet<>();

    public BattleGroupPlayer(UUID id, UUID battleGroupId, Integer playerId) {
        this.id = id;
        this.battleGroupId = battleGroupId;
        this.playerId = playerId;
    }

    public void addVillage(BattleGroupVillage village) {
        villages.add(village);
    }
}
