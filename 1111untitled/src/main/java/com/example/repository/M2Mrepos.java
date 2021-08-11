package com.example.repository;

import com.example.models.M2M;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface M2Mrepos extends CrudRepository<M2M, Long> {

    List<M2M> findByprice(String price);
}