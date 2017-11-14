/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.demo.spring5webappdemo.repositories.AuthorRepository;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Controller
public class AuthorController {
	private AuthorRepository authorRepo;

	/**
	 * @param authorRepo
	 */
	public AuthorController(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors";
	}
}
