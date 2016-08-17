package es.asauth.repository;

import es.asauth.domain.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Article> findAll() {
        return entityManager.createQuery("SELECT a FROM Article a").getResultList();
    }

    @Transactional
    public void save(Article article) {
        entityManager.persist(article);
    }
}
