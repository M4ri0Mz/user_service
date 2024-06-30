package com.inventoryandsalessystem.user.exeptions.errors;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
