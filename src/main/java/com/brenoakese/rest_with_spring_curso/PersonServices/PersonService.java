package com.brenoakese.rest_with_spring_curso.PersonServices;

import com.brenoakese.rest_with_spring_curso.Model.Person;
import com.brenoakese.rest_with_spring_curso.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;


    public Person findById(Long id) {
        logger.info("Finding person with id {}", id);


        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }


    public List<Person> findAll(){

        logger.info("Finding all persons");

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            people.add(mockPerson(i));
        }

        return people;
    }

    public Person create(Person person) {
        logger.info("Creating person {}", person);

        return personRepository.save(person);
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

    public Person update(Long id, Person person) {
       Person existingPerson = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));

        logger.info("Updating person with id {}", id);

        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setGender(person.getGender());

        return personRepository.save(existingPerson);
    }

    public void delete(Long id) {
        logger.info("Deleting person with id {}", id);
        personRepository.deleteById(id);
    }
}
