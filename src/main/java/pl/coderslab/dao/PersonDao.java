package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Student;
import pl.coderslab.pl.coderslab.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person b) {
        entityManager.persist(b);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }


}
