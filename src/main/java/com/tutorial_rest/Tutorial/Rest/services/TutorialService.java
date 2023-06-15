package com.tutorial_rest.Tutorial.Rest.services;

import org.springframework.stereotype.Service;

@Service
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
      System.out.println(t1);
      response = response.concat(t1.toString()).concat(" ");
    }
    return response;
  }
}
