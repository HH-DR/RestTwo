package de.reipka.resttwo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private ObjectMapper objectMapper;

    public List<Person> findAllPersons() {
        return null;
    }


    @Override
    public String createPerson(String json) {

        Person newPerson = null;
        objectMapper = new ObjectMapper();
        // configure objectmapper for input variants
        // automatic conversion of String into LocalDate
        objectMapper.registerModule(new JavaTimeModule());
        // switch off default mode of ObjectMapper that uses Timestamps
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // TODO: create isValidJson ,method and create validation for null values / requested values
        if (ValidatorService.isValidJson(json)) {

            try {
                newPerson = objectMapper.readValue(json, Person.class);
                personRepository.save(newPerson);
                return objectMapper.writeValueAsString(newPerson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return"PersonServiceImpl";
}













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
