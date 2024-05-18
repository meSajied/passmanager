package com.example.passmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Data;

@RestController
public class MainController {
  @Autowired
  DataService dataService;
  
  @PostMapping("/insert-data")
  public void insert(Data data) {
    dataService.createEntry(data);
  }

  @GetMapping("/fetch-data")
  public String fetch() {
    return dataService.fetchEntry("sssssss").getName();
  }

}
