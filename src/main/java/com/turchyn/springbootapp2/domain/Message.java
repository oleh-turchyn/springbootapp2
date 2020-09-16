package com.turchyn.springbootapp2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Data
@Getter
@Setter
@Entity
//@RequiredArgsConstructor

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

}
