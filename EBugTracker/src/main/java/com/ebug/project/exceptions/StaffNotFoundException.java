package com.ebug.project.exceptions;





import org.springframework.http.HttpStatus;

 import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND)

 public class StaffNotFoundException extends RuntimeException {



/**

 *

 */

 private static final long serialVersionUID = -2839659509191628623L;



public StaffNotFoundException(String message) {

 super(message);

 }



}
