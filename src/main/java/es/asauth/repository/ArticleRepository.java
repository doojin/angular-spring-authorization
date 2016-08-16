package es.asauth.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.asauth.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    @Autowired
    private ResourceLoader resourceLoader;

    private List<Article> articles = new ArrayList<>();

    @PostConstruct
    protected void init() throws IOException {
        Resource usersResource = resourceLoader.getResource("resources/articles.json");
        ObjectMapper mapper = new ObjectMapper();
        articles = mapper.readValue(
                usersResource.getInputStream(),
                mapper.getTypeFactory().constructCollectionType(List.class, Article.class)
        );
    }

    public List<Article> findAll() {
        return articles;
    }
}
