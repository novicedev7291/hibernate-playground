package com.example.model.battle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sun.text.bidi.BidiLine;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@NoArgsConstructor
@Table(name = "battle_group")
public class BattleGroup implements Serializable {
    private static final long serialVersionUID = 6396336405158170608L;

    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "battleGroupId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BattleGroupPlayer> players = new ArrayList();

    public BattleGroup(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addPlayer(BattleGroupPlayer player) {
        players.add(player);
    }
}
