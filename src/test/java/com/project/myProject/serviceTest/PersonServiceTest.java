package com.project.myProject.serviceTest;

import com.project.myProject.entity.Person;
import com.project.myProject.repository.PersonRepository;
import com.project.myProject.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;
    @Autowired
    private PersonService service;

    @Test
    public void personChecked() {
        given(repository.findById(1)).willReturn
                (Optional.of(new Person("Oleg", "Gonchar", 36)));
        given(repository.findById(2)).willReturn
                (Optional.of(new Person("Ivan", "Petrov", 24)));
        given(repository.findById(3)).willReturn
                (Optional.of(new Person("Nikita", "Kovtun", 23)));
        given(repository.findById(4)).willReturn
                (Optional.of(new Person("Igor", "Ivanov", 23)));
    }

    @Test
    public void exceptionChecked() {
        given(repository.findById(11)).willThrow(NoSuchElementException.class);
        given(repository.findById(100)).willThrow(NoSuchElementException.class);
        given(repository.findById(34)).willThrow(NoSuchElementException.class);
        given(repository.findById(432)).willThrow(NoSuchElementException.class);
    }
}