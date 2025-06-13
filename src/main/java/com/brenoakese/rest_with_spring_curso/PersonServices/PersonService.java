package com.brenoakese.rest_with_spring_curso.PersonServices;

import com.brenoakese.rest_with_spring_curso.DTOs.PersonDTO;
import com.brenoakese.rest_with_spring_curso.Model.Person;
import static com.brenoakese.rest_with_spring_curso.mapper.objectMapper.parseObjectList;
import static  com.brenoakese.rest_with_spring_curso.mapper.objectMapper.parseObject;
import com.brenoakese.rest_with_spring_curso.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;


    public PersonDTO findById(Long id) {
        logger.info("Finding person with id {}", id);

        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));

        return parseObject(person, PersonDTO.class);
    }


    public List<PersonDTO> findAll(){

        logger.info("Finding all persons");

       return parseObjectList(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating person {}", personDTO);

        var newPerson = parseObject(personDTO, Person.class);

        return parseObject(personRepository.save(newPerson), PersonDTO.class);
    }



    public PersonDTO update(Long id, PersonDTO person) {
       Person existingPerson = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));

        logger.info("Updating person with id {}", id);

        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setGender(person.getGender());

        return  parseObject(personRepository.save(existingPerson), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person with id {}", id);
        personRepository.deleteById(id);
    }
}
