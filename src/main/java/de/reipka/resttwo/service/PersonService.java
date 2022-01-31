package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    List<Person> findAllPersons();
    ResponseEntity<Person> createPerson(Person person);
}
