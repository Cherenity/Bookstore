package harjoitus.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import harjoitus.bookstore.domain.Book;
import harjoitus.bookstore.domain.BookRepository;
import harjoitus.bookstore.domain.CategoryRepository;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RestBookstoreController {

  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;

  public RestBookstoreController(BookRepository bookRepository, CategoryRepository categoryRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  }

  @GetMapping("/api/books")
  public Iterable<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/api/books/{id}")
  public Optional<Book> findById(@PathVariable("id") Long bookId) {
    return bookRepository.findById(bookId);
  }

}
