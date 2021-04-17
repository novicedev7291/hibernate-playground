package com.example.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class AnotherUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "anotherUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Role> roles = new ArrayList<>();

    public AnotherUser(String name) {
        this.name = name;
    }

    public void add(Role role) {
        roles.add(role);
        role.setAnotherUser(this);
    }

    public Integer getId() {
        return this.id;
    }
}
