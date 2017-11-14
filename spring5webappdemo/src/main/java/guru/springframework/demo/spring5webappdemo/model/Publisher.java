/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@NoArgsConstructor
@Entity
public @Data class Publisher {
	
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
}
