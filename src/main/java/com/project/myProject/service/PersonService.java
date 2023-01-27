package com.project.myProject.service;

import com.project.myProject.entity.Person;
import com.project.myProject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(int id) {
        try {
            Person currentPerson = personRepository.findById(id).get();
            currentPerson.setAge(2023-currentPerson.getAge());
            return currentPerson;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
