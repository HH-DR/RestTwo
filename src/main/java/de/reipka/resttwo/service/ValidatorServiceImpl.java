package de.reipka.resttwo.service;

import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

@Service
@AllArgsConstructor
class ValidatorServiceImpl implements ValidatorService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageSource messageSource;

    private final PersonRepository personRepository;

    public boolean isValidInput(Person person){
        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        logger.info("Number of Violations: " + violations.size());
        if(violations.size() == 0){
            logger.info("Validation passed.");
            return true;
        }

        violations.forEach(v -> logger.info(v.getMessage()));

        violations.forEach(vio -> logger.info(
                messageSource.getMessage(
                        vio.getMessage(),
                        null,
                        "DefaultMSG",
                        Locale.getDefault()))
        );


        return false;
    }


    @Override
    public boolean personExistsInDB(Person person) {

        Person testPerson = new Person();
        testPerson.setBirthdate(person.getBirthdate());
        testPerson.setLastName(person.getLastName());

        Example example =  Example.create(testPerson);

       // personRepository.exists(Example.of(example));
        return false;
    }


}
