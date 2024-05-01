package com.example.passmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.data.Data;

@Service
class DataService {
  @Autowired
  DataRepository dataRepository;

  @Transactional
  void createEntry(Data data) {
    dataRepository.save(data);
  }

  @Transactional
  Data fetchEntry(String name) {
    return dataRepository.findByName(name).orElse(null);
  }

}
