/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.demo.spring5webappdemo.model.Author;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
