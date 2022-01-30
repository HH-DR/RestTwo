package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    List<Person> findAllPersons();
    String createPerson(String json);
}
