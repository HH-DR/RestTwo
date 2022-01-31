package de.reipka.resttwo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final ValidatorService validatorService;

    private ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<Person> findAllPersons() {

        return  personRepository.findAll();
    }

    @Override
    public ResponseEntity<Person> createPerson(Person person) {

        if(validatorService.isValidInputJson(person)) {

            Person createdPerson = new Person();

            if (null != person.getFirstName()) {
                createdPerson.setFirstName(person.getFirstName());
            }
            createdPerson.setLastName(person.getLastName());
            createdPerson.setBirthdate(person.getBirthdate());

            personRepository.save(createdPerson);
            createdPerson.getId();
            personRepository.save(createdPerson);

            String savedPerson = createdPerson.getId() + ", " + createdPerson.getFirstName() + ", " + createdPerson.getLastName() + ", " + createdPerson.getBirthdate();

            logger.info("Person {} created.", savedPerson);

            return new ResponseEntity<Person>(createdPerson, HttpStatus.OK);

        } else {

            return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);

        }

    }


//    @Override
//    public String createPerson(String json) {
//
//        Person newPerson = null;
//        objectMapper = new ObjectMapper();
//        // configure objectmapper for input variants
//        // automatic conversion of String into LocalDate
//        objectMapper.registerModule(new JavaTimeModule());
//        // switch off default mode of ObjectMapper that uses Timestamps
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//
//        // TODO: create isValidJson ,method and create validation for null values / requested values
//        if (ValidatorService.isValidJson(json)) {
//
//            try {
//                newPerson = objectMapper.readValue(json, Person.class);
//                personRepository.save(newPerson);
//                return objectMapper.writeValueAsString(newPerson);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return"PersonServiceImpl";
//}













    private ObjectMapper provideConfiguredObjectMapper(){
        if(null == objectMapper){
            objectMapper = new ObjectMapper();
            // configure objectmapper for input variants
            // automatic conversion of String into LocalDate
            objectMapper.registerModule(new JavaTimeModule());
            // switch off default mode of ObjectMapper that uses Timestamps
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper;
        }
        return objectMapper;
    }



}
