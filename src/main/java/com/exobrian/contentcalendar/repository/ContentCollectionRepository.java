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

@Repository
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
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        /*
        Generates dummy data content for testing. PostConstruct anno are invoked right after constructing in the dependency injection.
         */
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);
    }
}
