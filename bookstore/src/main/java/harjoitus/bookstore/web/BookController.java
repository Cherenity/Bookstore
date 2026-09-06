package harjoitus.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitus.bookstore.domain.Book;
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

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "addbook";
    }
    

}
