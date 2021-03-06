package com.example.demo.repository;

import com.example.demo.entity.HelloEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HelloRepository  extends CrudRepository<HelloEntity, Integer> {
}
