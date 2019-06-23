package pl.coderslab.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
public abstract class GenericDao<T> {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> getAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<T> resultList = query.getResultList();
        return resultList;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }
}
