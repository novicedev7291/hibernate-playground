package com.example.model.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
@Getter
public class RoleId implements Serializable {
    private static final long serialVersionUID = -270972504383770774L;

    private Integer userId;
    private String code;

    public RoleId(String code) {
        this.code = code;
    }
}
