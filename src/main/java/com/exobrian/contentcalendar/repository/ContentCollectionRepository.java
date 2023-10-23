package com.exobrian.contentcalendar.repository;


import com.exobrian.contentcalendar.model.Content;
import com.exobrian.contentcalendar.model.Status;
import com.exobrian.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* This repository class uses the standard jdbc dependency which we've disabled in favor of
* sprint-data-jdbc. We'll be using the ContentRepository interface instead which Spring Boot will
* implement for us.
* */
//@Repository
public class ContentCollectionRepository {
    //Not a database. Used to keep pieces of content in memory so we can work with them in our app.

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){
    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        /*
        We may get a null response. Optionals allow a way to handle them.
        This method takes our content, turns it into a stream, then filters.
        Takes in c, gets its id, checks if equal to id input, then grabs the first it finds.
        */
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id() == content.id());
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        /*
        Generates dummy data content for testing. PostConstruct anno are invoked right after constructing in the dependency injection.
         */
        Content content = new Content(1,
                "My First Blog Post Title",
                "My first blog post description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
