package pl.skwarnel.dao;

import org.springframework.stereotype.Repository;
import pl.skwarnel.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Category> findAllCategories() {
        TypedQuery query = em.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

}
