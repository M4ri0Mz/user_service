package com.inventoryandsalessystem.user.exeptions.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ErrorResponse {
    private String message;
    private String statusCode;
}
