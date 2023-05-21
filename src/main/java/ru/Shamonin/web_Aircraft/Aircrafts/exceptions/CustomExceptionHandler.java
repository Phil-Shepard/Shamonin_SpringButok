package ru.Shamonin.web_Aircraft.Aircrafts.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorClass>> badGateWayException(MethodArgumentNotValidException exception) {
        List<ErrorClass> list = new ArrayList<>();
        for (FieldError error: exception.getBindingResult().getFieldErrors()) {
            var errorClass = new ErrorClass();
            errorClass.setErrorMessage(error.getDefaultMessage());
            errorClass.setFieldError(error.getField());
            list.add(errorClass);
        }
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<List<ErrorClass>>(list, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(DaoException.class)
    public ResponseEntity<ResponseError> badGateWayException(DaoException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(new ResponseError(exception.getMessage()), HttpStatus.BAD_GATEWAY);
    }
}
