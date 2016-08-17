package es.asauth.repository;

import es.asauth.domain.Article;
import es.asauth.domain.Role;
import es.asauth.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/db-test-context.xml")
public class ArticleRepositoryTest {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy/MM/dd");

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Before
    @Transactional
    public void setUp() {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
                       @Override
                       protected void doInTransactionWithoutResult(TransactionStatus status) {
                           entityManager.createQuery("DELETE FROM User").executeUpdate();
                           entityManager.createQuery("DELETE FROM Article").executeUpdate();
                       }
                   }
        );
    }

    @Test
    public void save() throws ParseException {
        List<Article> articles = articleRepository.findAll();
        assertThat(articles.size(), equalTo(0));

        User user = createUser();

        Article article = new Article();
        article.setTitle("Title");
        article.setText("Text");
        article.setAuthor(user);
        article.setDate(FORMATTER.parse("1991/03/21"));
        articleRepository.save(article);

        articles = articleRepository.findAll();
        assertThat(articles.size(), equalTo(1));
        assertThat(articles.get(0).getTitle(), equalTo("Title"));
        assertThat(articles.get(0).getText(), equalTo("Text"));
        assertThat(articles.get(0).getAuthor().getAccount(), equalTo("dmitry.papka@gmail.com"));
        assertThat(articles.get(0).getAuthor().getRole(), equalTo(Role.PUBLISHER));
        assertThat(articles.get(0).getDate().getTime(), equalTo(669510000000L));
    }

    private User createUser() {
        User user = new User();
        user.setAccount("dmitry.papka@gmail.com");
        user.setRole(Role.PUBLISHER);
        userRepository.save(user);
        return user;
    }
}