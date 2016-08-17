package es.asauth.converter;

import es.asauth.domain.Article;
import es.asauth.domain.User;
import es.asauth.dto.ArticleDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ArticleToArticleDTOConverterTest {

    private ArticleToArticleDTOConverter converter;

    @Before
    public void setUp() {
        converter = new ArticleToArticleDTOConverter();
    }

    @Test
    public void convert() {
        User user = mock(User.class);
        doReturn("dmitry.papka@gmail.com").when(user).getAccount();

        Date date = mock(Date.class);
        doReturn(123L).when(date).getTime();

        Article article = new Article();
        article.setId(1L);
        article.setTitle("Title");
        article.setText("Text");
        article.setAuthor(user);
        article.setDate(date);

        ArticleDTO dto = converter.convert(article);
        assertThat(dto.getId(), equalTo(1L));
        assertThat(dto.getTitle(), equalTo("Title"));
        assertThat(dto.getText(), equalTo("Text"));
        assertThat(dto.getAuthor(), equalTo("dmitry.papka@gmail.com"));
        assertThat(dto.getTimestamp(), equalTo(123L));
    }

}