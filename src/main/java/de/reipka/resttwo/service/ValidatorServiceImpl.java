package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class ValidatorServiceImpl implements ValidatorService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isValidInputJson(Person person){



        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        logger.info("Number of Violations: " + violations.size());
        if(violations.size() == 0){
            logger.info("Validation passed.");
            return true;
        }

        //violations.forEach(System.out::println);
        logger.info(violations.toString());
        return false;
    }


}
