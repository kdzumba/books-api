package kdzumba.spring.bookkeeper.configs;

import kdzumba.spring.bookkeeper.models.Book;
import kdzumba.spring.bookkeeper.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Book bloodWork = new Book(
                    "Blood Work",
                    "Michael Connely",
                    1200,
                    200
            );

            Book pelicanBrief = new Book(
                    "The Pelican Brief",
                    "John Grisham",
                    420,
                    233
            );

            Book theAssociate = new Book(
                    "The Associate",
                    "John Grisham",
                    384,
                    0
            );

            Book theRunawayJury = new Book(
                    "The Runaway Jury",
                    "John Grisham",
                    414,
                    0
            );

            //Save all the above books into the database
            repository.saveAll(List.of(bloodWork, pelicanBrief, theAssociate, theRunawayJury));
        };
    }
}
