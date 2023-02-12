package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager em;

    public void save(Article article) {
        em.persist(article);
    }

    public void update(Article article) {
        em.merge(article);
    }

    public void delete(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

    public List<Article> findAllArticles() {
        TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
        List<Article> results = query.getResultList();
        return results;
    }

}
