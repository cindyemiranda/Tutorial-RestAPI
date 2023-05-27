package com.tutorial_rest.Tutorial.Rest.messages;
/**
 * Clase que encapsula los mensajes que generan las peticiones HTTP
 * @author Cindy Miranda
 *
 */
public class ResponseMessage {
	 private String message;
	 
	 
	 public ResponseMessage(String _message ) {
		 this.message=_message;
	 }
	 public String getMessage() {
	   return message;
	 }
	 public void setMessage(String message) {
	   this.message = message;
	 }

}
