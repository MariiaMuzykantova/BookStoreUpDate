package fi.haagahelia.BookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.BookStore.domain.Book;
import fi.haagahelia.BookStore.domain.BookRepository;
import fi.haagahelia.BookStore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository repository;

	@Autowired
	private CategoryRepository ccrepository;

	
	@RequestMapping("/books")
	public String books(Model model) {

		model.addAttribute("books", repository.findAll());
		return "book"; // name of html
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "/booksRest", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookid, Model model) {
		repository.delete(bookid);
		return "redirect:../books"; // not html
	}

	@RequestMapping(value = "/booksRest/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findStudentRest(@PathVariable("id") Long bookid) {
		return repository.findOne(bookid);
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", ccrepository.findAll());
		return "addbook";
	}

	@RequestMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:books";
	}

	@RequestMapping("/update/{id}")
	public String updateBook(@PathVariable("id") Long bookid, Book book, Model model) {
		model.addAttribute("book", repository.findOne(bookid));
		model.addAttribute("categories", ccrepository.findAll());
		return "updatebook";
	}
}
