package harjoitus.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitus.bookstore.domain.Book;
import harjoitus.bookstore.domain.BookRepository;
import harjoitus.bookstore.domain.Category;
import harjoitus.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Lisätään demodataa h2-kantaan
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Fantasy");
			categoryRepository.save(category1);
			Category category2 = new Category("Mystery");
			categoryRepository.save(category2);

			// Haettu muutama oikea kirja netistä
			Book book1 = new Book("Howl's Moving Castle", "Diana Wynne Jones", 1986, "9780416615906", 14.99, category1);
			bookRepository.save(book1);

			Book book2 = new Book("Stardust", "Neil Gaiman", 1999, "9780063070714", 16.99, category2);
			bookRepository.save(book2);

			Book book3 = new Book("Coraline", "Neil Gaiman", 2002, "9780380807345", 13.99);
			bookRepository.save(book3);

		};

	}

}
