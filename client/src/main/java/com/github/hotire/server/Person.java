package com.github.hotire.server;

import lombok.Data;

@Data
public class Person {
    private Long id;

    private String name;

    private String surname;

    public Person(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
