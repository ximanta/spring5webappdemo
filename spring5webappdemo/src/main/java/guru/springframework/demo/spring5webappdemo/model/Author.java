/**
 * 
 */
package guru.springframework.demo.spring5webappdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author POJO
 * @author Mihai-Tudor Popescu
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="books")
@Entity
public @Data class Author {
	// id for author unique identification
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; // leakage between Relation and OO paradigms
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy="authors")
	//@JoinTable(name="author_book", joinColumns=@JoinColumn(name="author_id"), inverseJoinColumns=@JoinColumn(name="book_id"))
	private Set<Book> books = new HashSet<>();

	/**
	 * Constructor with arguments
	 * @param firstName The author's first name
	 * @param lastName The author's last name
	 */
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Author author = (Author) o;

		return id != null ? id.equals(author.id) : author.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", books=" + books +
				'}';
	}
}
