package com.ebug.project.exceptions;





import java.util.Date;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

 

@RestControllerAdvice
public class GlobalExceptionHandler {

 

    @ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(StaffNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

 

    @ExceptionHandler(BugNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException1(BugNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BugDetailsNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException2(BugDetailsNotFound exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException3(ProjectNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
  
    

}
 
