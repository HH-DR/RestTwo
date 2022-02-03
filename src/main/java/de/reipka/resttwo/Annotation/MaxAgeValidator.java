package de.reipka.resttwo.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MaxAgeValidator implements ConstraintValidator<MaxAge, LocalDate> {


    private static final int MAX_AGE = 126;

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        return dateOfBirth != null && dateOfBirth.plusYears(MAX_AGE).isAfter(LocalDate.now());
    }

}
