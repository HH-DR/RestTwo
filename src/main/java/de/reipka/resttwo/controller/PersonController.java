package de.reipka.resttwo.controller;

import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Get a list of all persons existing in the DB.")
    public ResponseEntity<List<Person>> createPersonWithoutJson(){

        logger.info("List of all Persons requested.");

        return new ResponseEntity<List<Person>>(personService.findAllPersons(), HttpStatus.OK);
    }


    @PostMapping( path = "person/post/create",
                  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                )
    @ResponseBody
    @ApiOperation(value = "Creates a new Person and saves it to DB.")
    //@SneakyThrows
    public ResponseEntity<Person> createPersonFromJson(@ApiParam(value = "lastName and birthDate are required") @RequestBody Person person) {

        return personService.createPerson(person);

    }



}
