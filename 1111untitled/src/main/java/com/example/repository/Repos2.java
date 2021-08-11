package com.example.repository;

import com.example.models.Name2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repos2 extends CrudRepository<Name2, Long> {

    List<Name2> findByname(String name);
}