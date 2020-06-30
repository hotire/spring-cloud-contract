package com.github.hotire.server;

import lombok.Getter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    @Getter
    private final RestTemplate restTemplate;

    public RestClient(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .rootUri("http://localhost:8080")
                .build();
    }

    public <T> T getForObject(final String url, final Class<T> responseType, final Object... uriVariables) {
        return restTemplate.getForObject(url, responseType, uriVariables);
    }
}
