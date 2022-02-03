package de.reipka.resttwo.domain;

import de.reipka.resttwo.Annotation.MinAge;
import de.reipka.resttwo.Annotation.MaxAge;
import de.reipka.resttwo.configuration.AppConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Locale;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {



    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "[a-z-A-Z-.]*", message = "Please use characters a-z and A-Z and \".\", only.")
    @Size(min = 2, max = 100, message = "Please use 3-100 characters")
    private String firstName;

    @NotNull(message = "{person.last.name.required}")
    @NotBlank(message="{person.last.name.not.empty}")
    @Pattern(regexp = "[a-z-A-Z]*", message = "{person.last.name.characters}")
    @Size(min = 3, max = 100, message = "Please use 3-100 characters")
    private String lastName;

    @Past(message = "{person.age.not.in.future}")
   // @NotBlank(message = "Date of birth must be a valid date.") // this validator does not work
    @MinAge(message = "{person.age.min}")
    @MaxAge(message = "{person.age.max}")
    @NotNull(message = "{person.age.required}")
    private LocalDate birthdate;
}
