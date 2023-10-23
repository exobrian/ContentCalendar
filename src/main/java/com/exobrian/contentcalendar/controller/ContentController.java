package com.exobrian.contentcalendar.controller;

import com.exobrian.contentcalendar.model.Content;
import com.exobrian.contentcalendar.model.Status;
import com.exobrian.contentcalendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/content")
public class ContentController {
    private final ContentRepository repository;

    @Autowired
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));
    }

    @GetMapping("/filter/keyword/{keyword}")
    public List<Content> findByKeyword(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.findAllByStatus(status);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.deleteById(id);
    }
}
