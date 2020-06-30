package com.github.hotire.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RestClient restClient;

    @GetMapping("/message/{personId}")
    public String getMessage(@PathVariable("personId") Long personId) {
        Person person = restClient.getForObject("http://localhost:8000/person/{personId}", Person.class, personId);
        return "Hello " + person.getName();
    }
}
