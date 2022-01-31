package de.reipka.resttwo.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping({"/", "", "home", "index"})
    public @ResponseBody
    ResponseEntity<String> sayHello() {

        String msg = "Welcome from {}";
        String path = "home";
        logger.info(msg, path);

        return new ResponseEntity<String>("Moin Moin", HttpStatus.OK);
    }


}









