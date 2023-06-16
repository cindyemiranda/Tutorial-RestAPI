package com.tutorial_rest.Tutorial.Rest.services;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TutorialService {

  public String getValueFibonacci(final Integer number) {
    return calculateFibonacciSerie(number);
  }

  private String calculateFibonacciSerie(final Integer number) {
    Integer f = 0;
    Integer t1 = 1;
    Integer t2;
    String response = "";
    for (int i = 1; i <= number; i++) {
      t2 = f;
      f = t1 + f;
      t1 = t2;
      response = response.concat(" ").concat(t1.toString()).concat(" ");
    }
    log.info(response);
    return response;
  }
}
