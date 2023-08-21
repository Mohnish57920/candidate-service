package com.altimetrikexample.cadidateservice.exception;

import com.altimetrikexample.cadidateservice.exception.exceptions.LowCreditException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(LowCreditException.class)
    public ResponseEntity lowCreditExceptionAdvice(HttpServletRequest req, LowCreditException exp){
        ErrorResponse error = new ErrorResponse.ErrorResponseBuilder()
                .code(400)
                .description(exp.getMessage())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(req.getRequestURI())
                .build();
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
