package de.reipka.resttwo.repository;

import de.reipka.resttwo.domain.Person;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
