package com.tutorial_rest.Tutorial.Rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial_rest.Tutorial.Rest.messages.ResponseMessage;
import com.tutorial_rest.Tutorial.Rest.services.TutorialService;
import com.tutorial_rest.Tutorial.Rest.utils.Constantes;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.time.ZoneId;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class TutorialController {

  @Autowired private TutorialService tutorialService;

  @GetMapping("/welcome")
  public ResponseEntity<ResponseMessage> getWelcome() {
    final String mensaje = Constantes.CODIGO_GENERAL_1;
    System.out.println(mensaje);
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

  @GetMapping("/system-property")
  public ResponseEntity<ResponseMessage> getSystemProperty() {
    final String propertyValue = System.getProperty(Constantes.PROPIEDAD_SISTEMA_OPERATIVO_2);
    String mensajePropiedad = "";
    if (propertyValue == null || propertyValue.isEmpty()) {
      mensajePropiedad = "La propiedad " + propertyValue + " no existe";
    } else {
      mensajePropiedad = propertyValue;
    }
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensajePropiedad));
  }

	@GetMapping("/get-countries-time")
	public ResponseEntity<ResponseMessage> getCountriesCode() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		ZoneId bogotaColombiaZoneID = ZoneId.of(Constantes.ZONE_COLOMBIA_BOGOTA);
		ZoneId elSalvadorZoneID = ZoneId.of(Constantes.ZONE_EL_SALVADOR);
		LocalDateTime nowBogota = LocalDateTime.now(bogotaColombiaZoneID);
		LocalDateTime nowElSalvador = LocalDateTime.now(elSalvadorZoneID);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("*************** La hora en Bogotá es: "+ dtf.format(nowBogota) + " ***************** La hora en el Salvador es: " + dtf.format(nowElSalvador)));	
	}

	@GetMapping("/Bye_bye")
	public ResponseEntity<ResponseMessage> getBye() {
    final String mensaje = "Bye bye";
    System.out.println(mensaje);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensaje));
  }

}
