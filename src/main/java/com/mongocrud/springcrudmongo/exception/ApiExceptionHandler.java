//package com.mongocrud.springcrudmongo.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
//@ControllerAdvice
//public class ApiExceptionHandler {
//    @ExceptionHandler(value = {FieldRequiredException.class})
//    public ResponseEntity<Object> handleFieldRequired(FieldRequiredException e){
//        ApiExceptionModel apiExceptionModel = new ApiExceptionModel(e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z"))
//        return new ResponseEntity<>(apiExceptionModel,HttpStatus.BAD_REQUEST);
//    }
//}
