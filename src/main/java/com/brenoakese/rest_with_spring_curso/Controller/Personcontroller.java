package com.brenoakese.rest_with_spring_curso.Controller;


import com.brenoakese.rest_with_spring_curso.Model.Person;
import com.brenoakese.rest_with_spring_curso.PersonServices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Personcontroller {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public Person findPesonById(@PathVariable("id") String id) {
        return personService.findById(id);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){

        return personService.findAll();

    }
}
