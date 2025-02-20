package com.ebug.project.exceptions;






import org.springframework.http.HttpStatus;

 import org.springframework.web.bind.annotation.ResponseStatus;



@SuppressWarnings("serial")

 @ResponseStatus(value = HttpStatus.NOT_FOUND)

 public class BugNotFoundException extends RuntimeException {



private static final int serialVersionUID = (int) 1L;

 public BugNotFoundException(String msg)

 {

 super(msg);

 }

 }
