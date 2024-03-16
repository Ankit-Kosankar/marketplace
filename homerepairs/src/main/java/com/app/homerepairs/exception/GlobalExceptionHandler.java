package com.app.homerepairs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.homerepairs.reponse.GeneralResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GeneralResponse> handleException(Exception ex, Model model) {
        //model.addAttribute("error", ex.getMessage());
        // You can return a view name or use ResponseEntity to send a JSON response
    	GeneralResponse generalResponse = new GeneralResponse();
    	generalResponse.setMessage("An Exception Occured!");
    	generalResponse.setError(ex.getMessage());
    	generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(generalResponse);
    }

    // Add more exception handlers as needed
}
