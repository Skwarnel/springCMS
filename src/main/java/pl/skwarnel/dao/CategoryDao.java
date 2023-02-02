package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager em;

    public void create(Category category) {
        em.persist(category);
    }

    public void update(Category category) {
        em.merge(category);
    }

    public void delete(Category category) {
        em.remove(em.contains(category) ? category : em.merge(category));
    }

}
