package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager em;


    public void create(Author author) {
        em.persist(author);
    }

    public void update(Author author) {
        em.merge(author);
    }

    public void delete(Author author) {
        em.remove(em.contains(author) ? author : em.merge(author));
    }

    public Author getAuthor(Long id) {
        Author author = em.find(Author.class, id);
        return author;
    }

    public List<Author> findAllAuthors() {
        TypedQuery query = em.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> authorList = query.getResultList();
        return authorList;
    }

    public List<Author> findAllAuthorsWithArticles() {
        TypedQuery query = em.createQuery("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.articles", Author.class);
        List<Author> authorList = query.getResultList();
        return authorList;
    }
}