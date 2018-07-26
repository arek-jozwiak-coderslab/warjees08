package pl.coderslab.web;


import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.BookRepository;

import java.util.ArrayList;
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

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes attributes){
        System.out.println(id);
        attributes.addFlashAttribute("infomessage", "Wiersz został usunięty");
        return "redirect:/book-list";
    }


    @RequestMapping("/book-list-by-author")
    @ResponseBody
    public String getListByAuthors(Model model){
        Author author = authorRepository.findOne(1l);

        List<Book> books = bookRepository.findBooksByAuthorsIn(Arrays.asList(author));
        List<Book> booksWithAuthors = bookRepository.findWithAuthorsQuery();

        booksWithAuthors.forEach(book -> {
            System.out.println(book.getAuthors());
        });
        List<Book> booksByQuery = bookRepository.findQuery(Arrays.asList(author));
        System.out.println("booksByQuery \n");
        booksByQuery.forEach(book -> {book.getAuthors().forEach(System.out::println);});

        bookRepository.changeTitle("Thinking in java", "Some other");

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        return "books/list";
    }

    @RequestMapping("/remove-book")
    public String removeBook(Model model){
        Book one = bookRepository.findOne(6l);
        bookRepository.delete(one);
        return "books/list";
    }

}
