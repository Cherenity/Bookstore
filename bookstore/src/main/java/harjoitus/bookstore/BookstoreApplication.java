package harjoitus.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitus.bookstore.domain.Book;
import harjoitus.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Lisätään demodataa h2-kantaan
	@Bean 
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Eka kirja", "Eka kirjailija");
			repository.save(book1);
			
			Book book2 = new Book("Toinen kirja", "Toinen kirjailija", 2020, "1234567890", 19.99);
			repository.save(book2);

		};

		
	}



}
