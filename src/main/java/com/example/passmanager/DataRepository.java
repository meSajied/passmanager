package com.example.passmanager;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Data;

@Repository
public interface DataRepository extends MongoRepository<Data, String> {
  Optional<Data> findByName(String name);
  Optional<Data> deleteByName(String name);
}
