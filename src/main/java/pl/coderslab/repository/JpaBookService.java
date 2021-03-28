package pl.coderslab.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.Book;
import pl.coderslab.interfejs.BookService;

import java.util.List;
import java.util.Optional;


@Repository
@Primary
public class JpaBookService implements BookService {


    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);

    }
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public void update(Book book) {
    }



}
