/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.demo.spring5webappdemo.model.Book;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
