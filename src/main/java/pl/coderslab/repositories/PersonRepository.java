package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.person.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{


    List<Person> findBestPeopleByFirstName(String name);
}
