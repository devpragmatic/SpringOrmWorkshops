package pl.coderslab.dao;

import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
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
