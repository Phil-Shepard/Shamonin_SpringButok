package ru.Shamonin.web_Aircraft.Aircrafts.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
@Min(200000)
@Max(10000000)
public @interface ValidateAircraftPrice  {
    public String message() default "Invalid aircraft name: name must be at least 4 and no more than 25 characters";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] paylod() default {};
}
