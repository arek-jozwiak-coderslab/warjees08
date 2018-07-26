package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookCustom{

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(long id);

    List<Book> findBooksByAuthorsIn(List<Author> authors); //ok

    @Query("select b from Book b join fetch b.authors a where a in ( ?1 ) ")
    List<Book> findQuery(List<Author> authors);


    //initialize books
    @Query("select b from Book b join fetch b.authors")
    List<Book> findWithAuthorsQuery();



}
