package com.example.asi5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.asi5.model.Person;
import com.example.asi5.service.PersonServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController implements WebMvcConfigurer {
    
    @Autowired
    PersonServiceImp personService;

    @GetMapping("/new")
    public String showFormNewPerson(Model model){
        Person p = new Person();
        model.addAttribute("person", p);
        return "new_person";
    }

    @PostMapping("/save")
    public String savePerson(@Valid @ModelAttribute("perosn") Person person,
        BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "new_person";
        }
        personService.addPerson(person);
        return "redirect:/person/list";
        }

}
