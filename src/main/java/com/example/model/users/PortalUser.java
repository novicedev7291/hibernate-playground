package com.example.model.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@Setter
@Table(name = "portal_user")
class PortalUser {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "portal_user_user_type",
            joinColumns = { @JoinColumn(name = "portal_user_id_fk")},
            inverseJoinColumns = { @JoinColumn(name = "user_type_id_fk") }
    )
    private Set<UserType> userTypes = new HashSet<>();

    public void addAll(UserType...types) {
        userTypes.addAll(Arrays.asList(types));
    }
}

