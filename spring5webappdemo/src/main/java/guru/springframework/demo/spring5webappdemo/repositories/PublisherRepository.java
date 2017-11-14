/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.demo.spring5webappdemo.model.Publisher;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
