package com.brenoakese.rest_with_spring_curso.repository;

import com.brenoakese.rest_with_spring_curso.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
