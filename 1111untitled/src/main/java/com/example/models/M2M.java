package com.example.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
public class M2M implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String descriptions;
    private String price;


    @ManyToMany
    @JoinTable(
            name = "m2m_desc",
            joinColumns = { @JoinColumn(name = "tovar_id") },
            inverseJoinColumns = { @JoinColumn(name = "name_id") }
    )
    private Set<M2M> name1s = new HashSet<>();




    public M2M(String name, String descriptions, String price) {


    }
}