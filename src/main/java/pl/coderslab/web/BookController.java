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

@Controller
public class BookController {

    private final BookDao bookDao;


    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
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
}
