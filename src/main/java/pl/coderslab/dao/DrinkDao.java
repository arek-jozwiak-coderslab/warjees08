package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Drink;
import pl.coderslab.entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class DrinkDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Drink> getAll() {
        Query query = entityManager.createQuery("select b FROM Drink b");
        return query.getResultList();
    }

    public Drink findById(long id) {
        return entityManager.find(Drink.class, id);
    }


}
