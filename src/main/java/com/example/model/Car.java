package com.example.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@Table(name = "car")
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Car {
    @Id
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wheel> wheels = new ArrayList<Wheel>();

    public void addWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}
