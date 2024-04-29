package com.example.passmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.passwords.Password;

@RestController
public class MainController {
  private Password pass = new Password();

  @Autowired
  private UserRepository ur;
  
  @GetMapping("/data")
  public String showData() {
    pass.setName("sssssss");
    pass.setPassword("Sajied");

    ur.save(pass);
    return "Hello";
  }
}
