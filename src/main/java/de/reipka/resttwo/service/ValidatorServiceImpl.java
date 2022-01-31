package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidatorServiceImpl implements ValidatorService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isValidInputJson(Person person){

        if (null != person.getLastName() && null !=  person.getBirthdate()) {
            logger.info("Birthdate and LastName passed");
            return true;
        }
        logger.info("Birthdate and Lastname are required.");
        return false;
    }


}
