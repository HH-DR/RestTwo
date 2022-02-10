package de.reipka.resttwo.annotation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

    private static final int MIN_AGE = 18;

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        return dateOfBirth != null && LocalDate.now().minusYears(MIN_AGE).isAfter(dateOfBirth);
    }
}
