package kdzumba.spring.bookkeeper.controllers;

import kdzumba.spring.bookkeeper.common.ResponseObject;
import kdzumba.spring.bookkeeper.models.Book;
import kdzumba.spring.bookkeeper.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    ResponseEntity<ResponseObject<List<Book>>> getBooks(){
        List<Book> allBooks = bookService.getBooks();
        ResponseObject<List<Book>> response =  new ResponseObject<>();
        response.timestamp = LocalDateTime.now();
        response.message = "Successfully retrieved books";
        response.status = HttpStatus.OK;
        response.result = allBooks;

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addNew")
    public ResponseEntity<ResponseObject<Book>> addNewBook(@RequestBody Book book){
        ResponseObject<Book> response = new ResponseObject<>();
        response.result = bookService.addNewBook(book);
        response.message = "Book successfully added";
        response.timestamp = LocalDateTime.now();
        response.status = HttpStatus.OK;

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getByBookId/{bookId}")
    public ResponseEntity<ResponseObject<Book>> getBookById(@PathVariable Long bookId){
        ResponseObject<Book> response = new ResponseObject<>();
        Optional<Book> book = bookService.getBookById(bookId);
        book.ifPresentOrElse(record -> {
            response.result = record;
            response.status = HttpStatus.OK;
            response.message = "Successfully retrieved book with given Id";
        }, () -> {
            response.result = null;
            response.status = HttpStatus.NOT_FOUND;
            response.message = String.format("Book with given id: %d not found", bookId);
        });
        response.timestamp = LocalDateTime.now();
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping("/getByAuthor")
    public ResponseEntity<ResponseObject<List<Book>>> getBooksByAuthor(@RequestParam(value = "author", defaultValue = "") String author){
        var response = new ResponseObject<List<Book>>();
        response.result = bookService.getBooksByAuthor(author);
        response.timestamp = LocalDateTime.now();
        response.status = HttpStatus.OK;
        response.message = String.format("Successfully retrieved list of books by: %s", author);
        return ResponseEntity.status(response.status).body(response);
    }
}
