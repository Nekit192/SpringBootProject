package com.project.myProject.controllerTest;

import com.project.myProject.controller.RESTController;
import com.project.myProject.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RESTControllerTest {
    @Autowired
    private RESTController controller;

    @Test
    public void testGetPersonById() {
        Person person1 = controller.getPersonById(1);
        assertThat(person1).isNotNull();
        assertThat(person1.getId()).isEqualTo(1);
        assertThat(person1.getName()).isEqualTo("Oleg");
        assertThat(person1.getSurname()).isEqualTo("Gonchar");
        assertThat(person1.getAge()).isEqualTo(36);
        Person person2 = controller.getPersonById(2);
        assertThat(person2).isNotNull();
        assertThat(person2.getId()).isEqualTo(2);
        assertThat(person2.getName()).isEqualTo("Ivan");
        assertThat(person2.getSurname()).isEqualTo("Petrov");
        assertThat(person2.getAge()).isEqualTo(24);
        Person nullPerson = controller.getPersonById(111);
        assertThat(nullPerson).isNull();
    }
}