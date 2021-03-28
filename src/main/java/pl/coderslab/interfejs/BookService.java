package pl.coderslab.interfejs;

import pl.coderslab.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {


    List<Book> getBooks();

    Optional<Book> get(Long id);

    Book add(Book book);

    void delete(Long id);

    void update(Book book);
}
