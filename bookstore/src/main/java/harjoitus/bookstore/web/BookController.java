package harjoitus.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitus.bookstore.domain.BookRepository;


@Controller
public class BookController {

    private final BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "This is the index page of the bookstore application.";
    }
    
    @GetMapping("/*")
    @ResponseBody
    public String fallback() {
        return "Empty page. Please check the URL.";
    }

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
  

}
