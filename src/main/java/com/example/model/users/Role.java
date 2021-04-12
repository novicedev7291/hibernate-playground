package com.example.model.users;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Getter
public class Role implements Serializable {
    private static final long serialVersionUID = 8309268913768942072L;

    @EmbeddedId
    private RoleId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    public void setId(RoleId id) {
        this.id = id;
    }

    void setUser(User user) {
        this.user = user;
    }
}
