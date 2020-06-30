package com.github.hotire.server;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {
    private final Map<Long, Person> personMap;

    public PersonService() {
        personMap = Map.of(
                1L, new Person(1L, "Richard", "Gere"),
                2L, new Person(2L, "Emma", "Choplin"),
                3L, new Person(3L, "Anna", "Carolina")
        );
    }

    public PersonService(Map<Long, Person> personMap) {
        this.personMap = personMap;
    }

    public Optional<Person> findPersonById(final Long id) {
        return Optional.ofNullable(personMap.get(id));
    }
}
