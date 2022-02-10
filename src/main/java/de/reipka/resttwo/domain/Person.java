package de.reipka.resttwo.domain;

import de.reipka.resttwo.annotation.MaxAge;
import de.reipka.resttwo.annotation.MinAge;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "[a-z-A-Z-.]*", message = "Please use characters a-z and A-Z and \".\", only.")
    @Size(min = 2, max = 100, message = "Please use 3-100 characters")
    private String firstName;

    @NotNull(message = "NotNull.Person.lastName")
    @NotBlank(message="person.last.name.not.empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "{person.last.name.characters}")
    @Size(min = 3, max = 100, message = "Please use 3-100 characters")
    private String lastName;

    @Past(message = "{person.age.not.in.future}")
    @MinAge(message = "{Person.birthdate.MinAge}")
    @MaxAge(message = "{person.age.max}")
    @NotNull(message = "{person.age.required}")
    private LocalDate birthdate;
}
