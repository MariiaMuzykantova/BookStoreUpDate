package fi.haagahelia.BookStore;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.BookStore.web.BookController;

public class SmokeTest {
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class HellotestApplicationTests {
	@Autowired
	private BookController controller;
	@Test
	public void contexLoads() throws Exception {
	assertThat(controller).isNotNull();
	}
	}
}
