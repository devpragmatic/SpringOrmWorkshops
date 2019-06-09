package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public List<Book> getAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<Book> resultList = query.getResultList();
        return resultList;
    }
    public List<Book> getLike(String title){
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.title like :title");
        query.setParameter("title", "%" + title + "%");
        List<Book> resultList = query.getResultList();
        return resultList;
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }
}
