package de.reipka.resttwo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "[a-z-A-Z-.]*", message = "Please only use characters a-z and A-Z")
    @Size(min = 2, max = 100, message = "Please use 3-100 characters")
    private String firstName;

    @NotNull
    @NotBlank(message="Last name is obligatory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Please only use characters a-z and A-Z")
    @Size(min = 3, max = 100, message = "Please use 3-100 characters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    //@Pattern(regexp = "\\d\\d\\d\\d-\\d\\d-\\d\\d", message = "Please use the following pattern: yyyy-mm-dd")
    @NotNull
    private LocalDate birthdate;
}
