package com.example.demo.controller;

import org.ojai.Document;
import org.ojai.store.Connection;
import org.ojai.store.DocumentStore;
import org.ojai.store.DriverManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

  @GetMapping
  public String hello(){

    Connection connection = DriverManager.getConnection("ojai:mapr:");
    DocumentStore store  = connection.getStore("/tables/docker-hello-test");
    Document object = store.findById("1");

    return object.getString("title");
  }

}
