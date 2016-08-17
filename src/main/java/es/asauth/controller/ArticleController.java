package es.asauth.controller;

import es.asauth.converter.ArticleToArticleDTOConverter;
import es.asauth.domain.Article;
import es.asauth.dto.ArticleDTO;
import es.asauth.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleToArticleDTOConverter articleConverter;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, ArticleToArticleDTOConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    @RequestMapping("/all")
    public @ResponseBody List<ArticleDTO> findAll() {
        List<Article> users = articleRepository.findAll();
        return articleConverter.convert(users);
    }
}
