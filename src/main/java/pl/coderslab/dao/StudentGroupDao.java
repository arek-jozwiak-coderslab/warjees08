package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class StudentGroupDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<StudentGroup> getAll() {
        Query query = entityManager.createQuery("select b FROM StudentGroup b");
        return query.getResultList();
    }

    public StudentGroup findById(long id) {
        return entityManager.find(StudentGroup.class, id);
    }


}
