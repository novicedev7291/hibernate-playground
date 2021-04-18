package com.example.model.course;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    private Integer id;

    @Column(name = "birth_place")
    private String birthPlace;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
