package de.reipka.resttwo.controller;

import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class PersonController {

    private final PersonService personService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(path = "person/get/all")
    public ResponseEntity<List<Person>> createPersonWithoutJson(){

        logger.info("List of all Persons requested.");

        return new ResponseEntity<List<Person>>(personService.findAllPersons(), HttpStatus.OK);
    }


    @PostMapping( path = "person/post/create",
                  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                )
    @ResponseBody
    //@SneakyThrows
    public ResponseEntity<Person> createPersonFromJson(@RequestBody Person person) {

        return personService.createPerson(person);

    }



}