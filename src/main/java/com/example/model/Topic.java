package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Topic {
    private String body;

    public Topic(String body) {
        this.body = body;
    }
}

