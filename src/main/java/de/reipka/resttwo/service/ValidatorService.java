package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;


public interface ValidatorService {

    boolean isValidInput(Person person);
    boolean personExistsInDB(Person person);

}

