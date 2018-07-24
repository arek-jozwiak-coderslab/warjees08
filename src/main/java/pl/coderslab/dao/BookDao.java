package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book b) {
        entityManager.persist(b);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public Book findByIdWithAuthors(long id) {

        Book book = entityManager.find(Book.class, id);
        book.getAuthors().size();
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("select b FROM Book b");
        return query.getResultList();
    }


}
