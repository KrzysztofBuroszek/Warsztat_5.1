package pl.coderslab.interfejs;

import pl.coderslab.Book;

import java.util.List;

public interface BookService {




    List<Book> getBooks();


    Book get(Long id);
    List<Book> getBookList();
    void add(Book book);
    void update(Book book);
    void delete(Long id);



}
