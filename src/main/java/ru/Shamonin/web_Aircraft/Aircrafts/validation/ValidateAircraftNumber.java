package ru.Shamonin.web_Aircraft.Aircrafts.validation;

import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AircraftNumberValidator.class)
public @interface ValidateAircraftNumber {
    public String message() default "Invalid aircraft number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
