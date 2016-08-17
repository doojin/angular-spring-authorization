package es.asauth.converter;

import es.asauth.domain.Article;
import es.asauth.dto.ArticleDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleToArticleDTOConverter implements Converter<Article, ArticleDTO> {

    @Override
    public ArticleDTO convert(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setText(article.getText());
        dto.setAuthor(article.getAuthor().getAccount());
        dto.setTimestamp(article.getDate().getTime());
        return dto;
    }

    public List<ArticleDTO> convert(List<Article> articles) {
        return articles.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
