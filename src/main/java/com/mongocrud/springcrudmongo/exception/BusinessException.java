package com.mongocrud.springcrudmongo.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{
    private String errorCode;
    private String errorMessage;


}
