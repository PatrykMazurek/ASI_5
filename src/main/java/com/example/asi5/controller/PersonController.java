package com.example.asi5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.asi5.model.Person;
import com.example.asi5.service.PersonServiceImp;

@Controller
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonServiceImp personService;


    @GetMapping("/list")
    public String showAllPersons(Model model){
        model.addAttribute("listPerson", personService.getAllPersons());
        return "list_person";
    }

    @GetMapping("/new")
    public String showFormNewPerson(Model model){
        Person p = new Person();
        model.addAttribute("person", p);
        return "new_person";
    }

    // @PostMapping("/save")

}
