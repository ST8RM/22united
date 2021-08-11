package com.example.repository;


import com.example.models.Name1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repos extends CrudRepository<Name1,Long> {


    }

