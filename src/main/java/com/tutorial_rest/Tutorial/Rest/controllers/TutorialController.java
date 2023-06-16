package com.tutorial_rest.Tutorial.Rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial_rest.Tutorial.Rest.messages.ResponseMessage;
import com.tutorial_rest.Tutorial.Rest.utils.Constantes;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.time.ZonedDateTime;
import java.time.ZoneId;

@RestController
public class TutorialController {
	@GetMapping("/welcome")
	public ResponseEntity<ResponseMessage> getWelcome(){
		String mensaje=Constantes.CODIGO_GENERAL_1;
		System.out.println(mensaje);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensaje));
		
	}

	@GetMapping("/get-datetime")
	public ResponseEntity<ResponseMessage> getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(dtf.format(now)));	
	}
	
    @GetMapping("/system-property")
    public ResponseEntity<ResponseMessage> getSystemProperty() {
        String propertyValue = System.getProperty(Constantes.PROPIEDAD_SISTEMA_OPERATIVO_2);
        String mensajePropiedad = "";
        if (propertyValue == null || propertyValue.isEmpty()) {
        	mensajePropiedad = "La propiedad " + propertyValue + " no existe";
        } else {
        	mensajePropiedad = propertyValue;
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensajePropiedad));
    }
	
	@GetMapping("/get-countries-time")
	public ResponseEntity<ResponseMessage> getCountriesCode(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		ZoneId bogotaColombiaZoneID = ZoneId.of(Constantes.ZONE_COLOMBIA_BOGOTA);
		ZoneId elSalvadorZoneID = ZoneId.of(Constantes.ZONE_EL_SALVADOR);
		LocalDateTime nowBogota = LocalDateTime.now(bogotaColombiaZoneID);
		LocalDateTime nowElSalvador = LocalDateTime.now(elSalvadorZoneID);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("*************** La hora en Bogotá es: "+ dtf.format(nowBogota) + " ***************** La hora en el Salvador es: " + dtf.format(nowElSalvador)));	
	}
	
}
