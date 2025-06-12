package com.brenoakese.rest_with_spring_curso.PersonServices;

import com.brenoakese.rest_with_spring_curso.Model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = LoggerFactory.getLogger(PersonService.class);


    public Person findById(String id) {
        logger.info("Finding person with id {}", id);

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Breno");
        person.setLastName("Akese");
        person.setAddress("BRASÍLIA - DF - BRASIL");
        person.setGender("MALE");

        return person;
    }


    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            people.add(mockPerson(i));
        }

        return people;
    }


    public Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Address " + i);
        person.setGender("MALE");

        return person;
    }
}
