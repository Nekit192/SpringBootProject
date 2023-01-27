package com.project.myProject.controller;

import com.project.myProject.entity.Person;
import com.project.myProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RESTController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }
}
