package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.pl.coderslab.person.Person;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{


}
