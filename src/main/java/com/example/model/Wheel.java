package com.example.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Table(name = "wheel")
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Wheel {
    @Id
    private Integer id;

    @Column(name = "car_id")
    private Integer carId;
}
