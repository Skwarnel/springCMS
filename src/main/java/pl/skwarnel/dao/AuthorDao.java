package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
