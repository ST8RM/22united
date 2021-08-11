package com.example.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity

public class OneByM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "description", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Name1> name1s;
}
