package fi.haagahelia.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.BookStore.domain.Book;
import fi.haagahelia.BookStore.domain.BookRepository;
import fi.haagahelia.BookStore.domain.CategoryRepository;
import fi.haagahelia.BookStore.domain.User;
import fi.haagahelia.BookStore.domain.UserRepository;
import fi.haagahelia.BookStore.domain.Category;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository ccrepository, UserRepository urepository) {
		return (args) -> {
			// Your code...add some demo data to db
			Category category1 = new Category ("Detective");
			Category category2 = new Category ("Drama");
			ccrepository.save(category1);
			ccrepository.save(category2);
			
			Book b1 = new Book ("ServerProgramming", "Juha Hinkula", 2017, 12345, 120, category1);
			Book b2 = new Book ("Programming", "Kari Silpio", 2016, 12345678, 90, category2);
			repository.save(b1);
			repository.save(b2);
			
			User user1 = new User("user",
					"$2a$04$VxgMarTlFX3pXMe86d./qOjRDZUXMCexbLliXFfneiC3umc/yWPpC", "USER");
					User user2 = new User("admin",
					"$2a$04$kgRUgUfM1hNdI07fkUsrveF9KumjCPvRIob447kJfShCwFGPwV66e", "ADMIN");
					urepository.save(user1);
					urepository.save(user2);

		};
	}
}
