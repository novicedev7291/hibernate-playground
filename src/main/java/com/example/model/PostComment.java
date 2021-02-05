package com.example.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@NoArgsConstructor(access = PRIVATE)
@Table(name = "post_comment")
public class PostComment {
    @Id
    private Integer id;
    private String review;
    //private Post post;

    public PostComment(Integer id, String review) {
        this.id = id;
        this.review = review;
    }
}
