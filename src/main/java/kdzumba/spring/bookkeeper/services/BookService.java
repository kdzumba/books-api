package kdzumba.spring.bookkeeper.services;

import kdzumba.spring.bookkeeper.serializers.JacksonSerializer;
import kdzumba.spring.bookkeeper.models.Book;
import kdzumba.spring.bookkeeper.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final JacksonSerializer<Book> serializer;

    @Autowired
    public BookService(BookRepository repository, JacksonSerializer<Book> converter){
        bookRepository = repository;
        this.serializer = converter;
    }

    public JacksonSerializer<Book> getSerializer() {
        return serializer;
    }

    public  List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book addNewBook(Book book) {
        Optional<Book> bookByTitle = bookRepository.findByTitleIgnoreCase(book.getTitle());
        bookByTitle.ifPresent(record -> {throw new IllegalStateException("Title already in database");});
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findByAuthorIgnoreCase(author);
    }
}
