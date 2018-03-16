package fi.haagahelia.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.BookStore.domain.Category;
import fi.haagahelia.BookStore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
    private CategoryRepository repository;
	@Test
    public void findByTitleShouldReturnCategory() {
    	List<Category> categories = repository.findByCategory("Detective");
    	assertThat(categories).hasSize(1);
    	assertThat(categories.get(0).getName()).isEqualTo("Detective");
    	}
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Detective");
    	repository.save(category);
    	assertThat(category.getId()).isNotNull();
    }
    
   
}