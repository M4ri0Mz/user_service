package com.inventoryandsalessystem.user.utils;

import com.inventoryandsalessystem.user.exeptions.errors.UserNotFound;
import com.inventoryandsalessystem.user.exeptions.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String STATUS_CODE_400 = "400";
    public static final String STATUS_CODE_404 = "404";
    private static final String STATUS_CODE_500 = "500";

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundExeption(Exception exception) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(exception.getMessage());
        response.setStatusCode(STATUS_CODE_404);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
