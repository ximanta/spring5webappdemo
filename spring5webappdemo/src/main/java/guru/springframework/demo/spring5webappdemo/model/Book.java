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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book POJO
 * @author Mihai-Tudor Popescu
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class Book {
	// id for author unique identification
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; // leakage between Relation and OO paradigms
	private String title;
	private String isbn;
	
	@OneToOne
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

	/**
	 * Constructor with arguments
	 * @param title
	 * @param isbn
	 * @param publisher
	 */
	public Book(String title, String isbn, Publisher publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		return id != null ? id.equals(book.id) : book.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				", publisher='" + publisher + '\'' +
				", authors=" + authors +
				'}';
	}
}
