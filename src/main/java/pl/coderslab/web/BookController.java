package pl.coderslab.web;


import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.BookRepository;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookController(BookDao bookDao, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookDao = bookDao;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @ResponseBody
    @RequestMapping("/add-book")
    public String addBook(){
        Book b = new Book();
        b.setTitle("Thinking in Java");
        b.setPageNumber(1000);
        bookDao.save(b);
        return "--added--";
    }

    @ResponseBody
    @RequestMapping("/get-book")
    public String getBook(){
        Book b = bookDao.findByIdWithAuthors(1);

        return "book: " + b + "author + "+ b.getAuthor().toString() + " authors = " + b.getAuthors() ;
    }
    @RequestMapping("/book-list")
    public String getList(Model model){
        model.addAttribute("books", bookDao.getAll());
        return "books/list";
    }


    @RequestMapping("/book-list-by-author")
    @ResponseBody
    public String getListByAuthors(Model model){
        Author author = authorRepository.findOne(1l);
        List<Book> books = bookRepository.findBooksByAuthorsIn(Arrays.asList(author));
//        List<Book> booksByQuery = bookRepository.findQuery(Arrays.asList(author));

        bookRepository.changeTitle("Thinking in java", "Some other");

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        return "books/list";
    }

}
