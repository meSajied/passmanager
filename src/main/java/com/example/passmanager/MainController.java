package com.example.passmanager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Data;

@RestController
public class MainController {
  @Autowired
  DataService dataService;
  
  @PostMapping("/insert-data")
  public HttpStatus insert(@RequestBody Data data) {
    Data d = dataService.createEntry(data);
    return d != null ? HttpStatus.CREATED : HttpStatus.EXPECTATION_FAILED;
  }

  @PostMapping("/fetch-data")
  public String fetch(@RequestBody Data data) {
    return dataService.fetchEntry(data.getName());
  }

  @PostMapping("/update-data")
  public HttpStatus update(@RequestBody Data data) {
    Data d = dataService.updateDataByName(data);
    return d != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
  }

  @PostMapping("/delete-data")
  public HttpStatus delete(@RequestBody Data data) {
    Optional<Data> d = dataService.deleteEntry(data.getName());
    return d != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

  }
}
