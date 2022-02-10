package de.reipka.resttwo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

@RestController
public class UuidController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("get/uuid")
    public ResponseEntity<UUID> getUuid(){

        UUID uuid = UUID.randomUUID();
        logger.info("random uuid: " + uuid);

        return new ResponseEntity<UUID>(uuid, HttpStatus.OK);
    }

}
