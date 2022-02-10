package de.reipka.resttwo.controller;

import de.reipka.resttwo.domain.Person;
import de.reipka.resttwo.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    PersonController personController;
    @Mock
    PersonService personService;
    @Mock
    MessageSource messageSource;

    @BeforeEach
    void setUp(){
        // mocks all objects of class PersonController
        MockitoAnnotations.openMocks(this);

        // Because AllArgsConstructor MessageSource and Personservice have to be provided
        personController = new PersonController(personService, messageSource);
    }

    @Test
    void getAllPersons() {

        Person person = Person.builder()
                .birthdate(LocalDate.now().minusYears(20))
                .lastName("lastName")
                .firstName("firstName")
                .build();
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        ResponseEntity<List<Person>> responseEntity = ResponseEntity.ok(personList);
        // when personService is requested return the following personList
        when(personService.findAllPersons()).thenReturn(personList);

        ResponseEntity<List<Person>> allPersons = personController.getAllPersons();

        assertEquals(personList.size(), allPersons.getBody().size());
        assertNotEquals(2, allPersons.getBody().size());

        // verifies that the mock fromn personService has called method findAllPersons() exactly 1 time
        verify(personService, times(1)).findAllPersons();
    }

    @Test
    void createPerson() {

//      UnitTest




//        IntegrationTest
//        Person person = Person.builder()
//                .firstName("firstName")
//                .lastName("lastName")
//                .birthdate(LocalDate.now().minusYears(20))
//                .build();
//        ResponseEntity<Person> responseEntity = personController.createPerson(person);
//
//        Assertions.assertTrue(  responseEntity.getStatusCode().is2xxSuccessful() &&
//                                person.getLastName().equals(responseEntity.getBody().getLastName()) &&
//                                person.getFirstName().equals(responseEntity.getBody().getFirstName()) &&
//                                person.getBirthdate().equals(responseEntity.getBody().getBirthdate())
//        );


    }
}