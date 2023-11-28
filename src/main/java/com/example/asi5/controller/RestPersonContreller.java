package com.example.asi5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.asi5.repository.PersonRepository;

import jakarta.websocket.server.PathParam;

import com.example.asi5.model.Person;

import java.util.*;

@RestController
@RequestMapping("/api/person")
public class RestPersonContreller {
    
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public List<Person> getAlPerson(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathParam("id") long id){
        return personRepository.findById(id).orElseThrow();
    }

}
