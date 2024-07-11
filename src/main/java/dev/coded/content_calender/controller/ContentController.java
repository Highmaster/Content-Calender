package dev.coded.content_calender.controller;

import dev.coded.content_calender.model.Content;
import dev.coded.content_calender.model.Status;
import dev.coded.content_calender.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // controller is a class that accepts request and return a response
@RequestMapping("/api/content") //path to the controller
@CrossOrigin()
public class ContentController {

    private final ContentRepository repository;



    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    //make a request and find all the pieces of content on the system
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    //Create Read Update Delete - filter | paging and sorting
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(" ")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public  List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return  repository.listByStatus(status);
    }

}
