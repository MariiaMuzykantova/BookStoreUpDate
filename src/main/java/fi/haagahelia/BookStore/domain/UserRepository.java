package fi.haagahelia.BookStore.domain;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.BookStore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);

fi.haagahelia.BookStore.domain.User findByUserName(String string);
}
