package com.exobrian.contentcalendar.config;

import com.exobrian.contentcalendar.model.Content;
import com.exobrian.contentcalendar.repository.ContentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.List;

/*
* Comment annotation to have Spring Boot create this bean for us here after dependency injections
* Otherwise, comment out. Or can leave uncommented, and then create the bean on this method somewhere else like the application class.
* */
@Component
//@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello 🌍 from the DataLoader class! This is shown in production only!");

        if ()
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}