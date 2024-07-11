package dev.coded.content_calender.repository;

import dev.coded.content_calender.model.Content;
import dev.coded.content_calender.model.Status;
import dev.coded.content_calender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentRepository() {

    }
    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c ->  c.id().equals(id)).findFirst();

    }

    public void save(Content content) {
        contentList.removeIf(c-> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(content);

    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c ->c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c-> c.id().equals(id));
    }

    public void deleteById(Integer id) {
    }
}
