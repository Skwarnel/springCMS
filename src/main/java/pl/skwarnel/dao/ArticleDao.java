package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
