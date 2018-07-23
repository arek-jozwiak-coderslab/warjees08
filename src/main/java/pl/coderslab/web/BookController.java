package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
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
        Book b = bookDao.findById(1);
        return "book: " + b;
    }
}
