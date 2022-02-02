package de.reipka.resttwo.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping({"/", "", "home", "index"})
    public @ResponseBody
    ResponseEntity<List<String>> sayHello() {

        List<String> list = new ArrayList<>();
        list.add("Moin");
        list.add("Moin");
        String msg = "Welcome from {}";
        String path = "home";
        logger.info(msg, path);

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }


}









