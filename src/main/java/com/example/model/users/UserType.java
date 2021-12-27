package com.example.model.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@Setter
@Table(name = "user_type")
@EqualsAndHashCode(of  = "typeName")
public class UserType {

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    private Integer id;

    @Id
    @Column(name = "type")
    private String typeName;

    public UserType() {}

    public UserType(String name) {
        this.typeName = name;
    }

}
