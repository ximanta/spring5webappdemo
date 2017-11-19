/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.demo.spring5webappdemo.model.Author;
import guru.springframework.demo.spring5webappdemo.model.Book;
import guru.springframework.demo.spring5webappdemo.model.Publisher;
import guru.springframework.demo.spring5webappdemo.repositories.AuthorRepository;
import guru.springframework.demo.spring5webappdemo.repositories.BookRepository;
import guru.springframework.demo.spring5webappdemo.repositories.PublisherRepository;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private PublisherRepository publisherRepo;

	/**
	 * Constructor with arguments - initialize the object with the repositories
	 * @param authorRepo
	 * @param bookRepo
	 */
	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// call initData
		this.initData();
		
	}
	
	private void initData() {
		//add a few authors and books
		//Mark Twain

		Publisher arthur = new Publisher("Editura Arthur", "C.P. 4, O.P. 83, cod 062610, sector 6, Bucureşti\r\n"); // Saving the phone no. here in case I need it in further app development so I don't have to re-google it :D "Tel: 021.369.31.99"
		this.publisherRepo.save(arthur);

		Author markTwain = new Author("Mark", "Twain");
		Book tomSawyer = new Book("The Adventures of Tom Sawyer", "9788804305309", arthur);

        markTwain.getBooks().add(tomSawyer);
        tomSawyer.getAuthors().add(markTwain);
		this.authorRepo.save(markTwain);
        this.bookRepo.save(tomSawyer);
	//George Calinescu

		Publisher litera = new Publisher("Litera International", "Contact. Grup Editorial Litera SRL. B-dul Dimitrie Pompeiu, nr. 5-7, etaj 8, biroul nr. 3, sector 2, Bucureşti, România");
        this.publisherRepo.save(litera);

        Author gCalinescu = new Author("George", "Călinescu");
		Book roLitHistory = new Book("Istoria literaturii române de la origini până în prezent", "9789975904704", litera);
        gCalinescu.getBooks().add(roLitHistory);
		roLitHistory.getAuthors().add(gCalinescu);
       	this.authorRepo.save(gCalinescu);
        this.bookRepo.save(roLitHistory);
	}

}
