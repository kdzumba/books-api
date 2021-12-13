package kdzumba.spring.bookkeeper.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
public class Book{
    @Id
    @SequenceGenerator(
            name="book",
            sequenceName="book_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String title;
    private String author;
    private Integer numberOfPages;
    private Integer currentPage;

    public Book(String title, String author, Integer numberOfPages, Integer currentPage) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.currentPage = currentPage;
    }
}