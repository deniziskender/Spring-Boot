package com.example.libraryapi.base;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIT {
    @LocalServerPort
    private int serverPort;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    protected TestRestTemplate testRestTemplate;

    @SneakyThrows
    @PostConstruct
    private void postConstruct() {
        testRestTemplate = new TestRestTemplate(restTemplateBuilder.rootUri("http://localhost:" + serverPort));
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // Setting Spring Boot SetTimeZone
    }
}
