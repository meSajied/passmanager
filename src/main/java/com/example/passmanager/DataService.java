package com.example.passmanager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.data.Data;

@Service
class DataService {
  @Autowired
  DataRepository dataRepository;

  @Transactional
  Data createEntry(Data data) {
    return dataRepository.save(data);
  }

  @Transactional
  String fetchEntry(String name) {
    Data data = dataRepository.findByName(name).orElse(null);
    return data.getPassword();
  }

  @Transactional
  Data updateDataByName(Data data) {
    return dataRepository.findByName(data.getName()).map(existingData -> {
      return updateData(existingData, data);
    }).orElse(null);
  }

  private Data updateData(Data existingData, Data newData) {
    existingData.setName(newData.getName());
    existingData.setPassword(newData.getPassword());

    return dataRepository.save(existingData);
  }

  @Transactional
  Optional<Data> deleteEntry(String name) {
    return dataRepository.deleteByName(name);
  }
}
