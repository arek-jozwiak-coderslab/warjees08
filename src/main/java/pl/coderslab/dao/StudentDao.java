package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student b) {
        entityManager.persist(b);
    }




}
