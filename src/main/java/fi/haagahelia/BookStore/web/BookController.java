package fi.haagahelia.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	model.addAttribute("books",repository.findAll()); 
	return "book"; //name of html 
	} 
@RequestMapping("/delete/{id}") 
public String deleteBook(@PathVariable("id") Long bookid, Model model) { 
repository.delete(bookid); 
return "redirect:../books"; // not html 
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




