package com.example.model.battle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Table(name = "battle_group_village")
public class BattleGroupVillage implements Serializable {
    private static final long serialVersionUID = -4928557296423893476L;

    @EmbeddedId
    private BattleGroupVillageId id;

    private String name;
}
