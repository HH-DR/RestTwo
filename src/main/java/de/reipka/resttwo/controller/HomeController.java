package de.reipka.resttwo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.service.PersonService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RestController(value = "Person")
//@AllArgsConstructor
public class HomeController {

    // TODO: check if constructor is ok practice
    // no bean of Logger present, but (AllArguments*)Constructor necessary for constructor injection of PersonService
    public HomeController(PersonService personService) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.personService = personService;
    }

    private final Logger logger;

    private final PersonService personService;


    @GetMapping({"/", "", "home", "index"})
    public @ResponseBody
    ResponseEntity<String> sayHello() {

        String msg = "Moin from sayHello()";
        logger.info(msg);

        return new ResponseEntity<String>("Moin Moin", HttpStatus.OK);
    }


    @GetMapping(path = "person/get")
    public String createPersonWithoutJson(){

        String person = "{\n" +
                "\t\"firstName\": \"Bert\",\n" +
                "\t\"lastName\": \"Sesame\",\n" +
                "\t\"birthdate\": \"1975-11-11\"\n" +
                "}";
        logger.info("Person from GetMapping");

        return personService.createPerson(person);
    }


    @PostMapping(path = "person/post",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public Person createPersonFromJson(Person person) {

        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getBirthdate());
        Person newPerson = new Person();
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName((newPerson.getLastName()));

        logger.info("Person from PostMapping");


        return newPerson;

    }

}









