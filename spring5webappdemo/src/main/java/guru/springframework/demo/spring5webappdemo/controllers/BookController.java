/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.demo.spring5webappdemo.repositories.BookRepository;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Controller
public class BookController {
	
	private BookRepository bookRepo;
	
	/**
	 * @param bookRepo
	 */
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}


	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll()); 
		return "books";
	}
}
