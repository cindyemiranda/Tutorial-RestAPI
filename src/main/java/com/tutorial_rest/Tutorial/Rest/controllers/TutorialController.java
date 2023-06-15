package com.tutorial_rest.Tutorial.Rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial_rest.Tutorial.Rest.messages.ResponseMessage;
import com.tutorial_rest.Tutorial.Rest.services.TutorialService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class TutorialController {

  @Autowired private TutorialService tutorialService;

  @GetMapping("/welcome")
  public ResponseEntity<ResponseMessage> getWelcome() {
    final String mensaje = "Welcome!!!";
    log.info(mensaje);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensaje));
  }

  @GetMapping("/get-datetime")
  public ResponseEntity<ResponseMessage> getCurrentDate() {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    final LocalDateTime now = LocalDateTime.now();
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(dtf.format(now)));
  }

  @GetMapping("/get-fibonacci-serie/{value}")
  public ResponseEntity<ResponseMessage> getFibonacciSerie(@PathVariable final String value) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseMessage(tutorialService.getValueFibonacci(Integer.parseInt(value))));
  }
}
