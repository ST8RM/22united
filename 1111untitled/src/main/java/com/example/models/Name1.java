package com.example.models;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor

@Entity
@AllArgsConstructor

@Getter
@Setter
@Builder
public class Name1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;
    private Integer price;
    private String image;
    @OneToOne(mappedBy = "name1")
    private Name2 name2;


//findbytext, deletebytext, Post , Boot

    public Name1(String name, String description, Integer price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    public Name1(String name, String description, String price) {

    }

    public Name1(String name, String description, Integer price) {
    }
}




