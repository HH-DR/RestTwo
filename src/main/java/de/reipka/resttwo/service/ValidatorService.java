package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;


public interface ValidatorService {

    boolean isValidInputJson(Person person);

}

