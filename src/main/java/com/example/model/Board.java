package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {
    @Id
    private Integer id;
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "topics", joinColumns = @JoinColumn(name = "topic_id"))
    List<Topic> topics = new ArrayList<>();

    public Board(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
