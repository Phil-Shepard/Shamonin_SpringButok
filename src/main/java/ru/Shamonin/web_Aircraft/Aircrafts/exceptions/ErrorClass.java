package ru.Shamonin.web_Aircraft.Aircrafts.exceptions;

import lombok.Data;

@Data
public class ErrorClass {
    private String errorMessage;
    private String fieldError;
}
