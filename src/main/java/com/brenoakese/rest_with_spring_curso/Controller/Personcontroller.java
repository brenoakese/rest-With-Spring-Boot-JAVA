package com.brenoakese.rest_with_spring_curso.Controller;


import com.brenoakese.rest_with_spring_curso.DTOs.PersonDTO;
import com.brenoakese.rest_with_spring_curso.Model.Person;
import com.brenoakese.rest_with_spring_curso.PersonServices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Personcontroller {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findPesonById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }


    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
    public List<PersonDTO> findAll(){ return personService.findAll(); }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) { return personService.create(person); }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@PathVariable("id") Long id, @RequestBody PersonDTO person) {
       return personService.update(id, person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {


        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
