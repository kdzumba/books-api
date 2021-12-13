package kdzumba.spring.bookkeeper.repositories;

import kdzumba.spring.bookkeeper.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleIgnoreCase(String title);
    List<Book> findByAuthorIgnoreCase(String author);
}

