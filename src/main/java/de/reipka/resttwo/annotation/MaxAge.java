package de.reipka.resttwo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented                                         // register annotation in spring
@Retention(RetentionPolicy.RUNTIME)                 // scope of annotation - during runtime
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})        // elements to which annotation can be applied
@Constraint(validatedBy = MaxAgeValidator.class)    // class, that validates the constraint
public @interface MaxAge {
    String message() default "{maxAge}";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
