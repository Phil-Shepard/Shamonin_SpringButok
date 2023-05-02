package ru.Shamonin.web_Aircraft.Aircrafts.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AircraftNumberValidator implements ConstraintValidator<ValidateAircraftNumber, String> {
    @Override
    public void initialize(ValidateAircraftNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String aircraftNumber, ConstraintValidatorContext constraintValidatorContext){
        return aircraftNumber.matches("^[ЙЦУКЕНГШЩЗФЫВАПРОЛДЖЭЯЧСМИТЬБЮ]\\d{3}(?<!000)[ЙЦУКЕНГШЩЗФЫВАПРОЛДЖЭЯЧСМИТЬБЮ]{2}\\d{2,3}$");
    }
}
