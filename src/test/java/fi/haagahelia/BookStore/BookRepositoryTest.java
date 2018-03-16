package fi.haagahelia.BookStore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.BookStore.domain.Book;
import fi.haagahelia.BookStore.domain.BookRepository;
import fi.haagahelia.BookStore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
    	List<Book> books = repository.findByTitle("ServerProgramming");
    	assertThat(books).hasSize(1);
    	assertThat(books.get(0).getTitle()).isEqualTo("ServerProgramming");
    	}
    
    @Test
    public void createNewBook() {
    	Book book = new Book("ServerProgramming", "Juha Hinkula", 2017, 12345, 120, new Category("Detective"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteNewBook() {
    	Book book = new Book("ServerProgramming", "Juha Hinkula", 2017, 12345, 120, new Category("Detective"));
    	repository.save(book);
    	repository.delete(book.getId());
    	assertThat(book.getId()).isNull();
    }
    
   
}
