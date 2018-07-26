package pl.coderslab.repositories;

import pl.coderslab.entity.Book;
import pl.coderslab.pl.coderslab.person.Person;

public interface BookCustom {

    public Book findByIdWithAuthors(Long id);
    public void changeTitle(String originalTitle, String newTitle);
}
