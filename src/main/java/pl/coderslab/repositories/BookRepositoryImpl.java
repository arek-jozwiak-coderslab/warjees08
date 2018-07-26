package pl.coderslab.repositories;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookRepositoryImpl implements BookCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findByIdWithAuthors(Long id) {
        Book book = entityManager.find(Book.class, id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    @Override
    public void changeTitle(String originalTitle, String newTitle) {
        Query q = entityManager
                .createQuery(
                        "Update Book p set p.title = :newTitle" +
                                " where p.title= :originalTitle");
        q.setParameter("newTitle", newTitle)
                .setParameter("originalTitle", originalTitle)
                .executeUpdate();
    }
}

