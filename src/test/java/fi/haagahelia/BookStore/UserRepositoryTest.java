package fi.haagahelia.BookStore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.BookStore.domain.User;
import fi.haagahelia.BookStore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private UserRepository repository;
	@Test
    public void findByUserNameShouldReturnUser() {
    	User users = repository.findByUserName("user");
    	assertThat(users.getUsername()).isEqualTo("user");
    	}
    
    @Test
    public void createNewBook() {
    	User user = new User("user", "$2a$04$VxgMarTlFX3pXMe86d./qOjRDZUXMCexbLliXFfneiC3umc/yWPpC", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    
}
