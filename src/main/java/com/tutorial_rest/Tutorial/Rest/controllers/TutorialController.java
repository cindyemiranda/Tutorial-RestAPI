package com.tutorial_rest.Tutorial.Rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial_rest.Tutorial.Rest.messages.ResponseMessage;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  


@RestController
public class TutorialController {
	@GetMapping("/welcome")
	public ResponseEntity<ResponseMessage> getWelcome(){
		String mensaje="Welcome!!!";
		System.out.println(mensaje);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(mensaje));
		
	}

	@GetMapping("/get-datetime")
	public ResponseEntity<ResponseMessage> getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(dtf.format(now)));	
	}
}
