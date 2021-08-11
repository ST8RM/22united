package com.example.repository;

import com.example.models.Name1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OneTmRep extends CrudRepository<Name1, Long> {

    List<Name1> findBydescription(String description);
}