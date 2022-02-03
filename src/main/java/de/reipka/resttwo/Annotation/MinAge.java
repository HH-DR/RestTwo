package de.reipka.resttwo.Annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented                                     // kind of register annotation in Spring
@Retention(RetentionPolicy.RUNTIME)             // declare scope of annotation -> accessible during runtime
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})    // Elements to which the Annotation can be applied - all other elements generate an error
@Constraint(validatedBy = MinAgeValidator.class)
public @interface MinAge {
    String message() default "{minAge}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
