package com.example.passmanager;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.passwords.Password;

@Repository
public interface UserRepository extends MongoRepository<Password, String> {
  
}
