package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;

public interface ValidatorService {

    public boolean isValidInputJson(Person person);

}
