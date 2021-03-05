// usunąć nadmiarowy kod, zwłaszcza w loggerach !!!!!!!!!!!!!!!!!!!!!
//delete dokończyć.
// zrobić przekierowanie na stronę główną.

package pl.coderslab;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


@Component
public class MemoryBookService {

    private static final Logger log = LoggerFactory.getLogger(MemoryBookService.class);
    private static Long newId;
    private List<Book> listOfBooks;


    public MemoryBookService() {
        listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        listOfBooks.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        listOfBooks.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
        listOfBooks.add(new Book(4L, "9999999999999", "Virion", "Nellu", "Helion", "okokolaj"));
    }

    public List<Book> getList() {
        log.info("All books********************************************************");
        return listOfBooks;
    }


    public Book BookId(Long id) {
        listOfBooks = books();
        try {
            listOfBooks
                    .stream()
                    .filter(book -> book.getId().equals(id))
                    .collect(Collectors.toList());

            log.info("book" + listOfBooks.get(Math.toIntExact(id) - 1) + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            log.info("Index" + id + " out of bounds for length");
        }
        return listOfBooks.get(Math.toIntExact(id) - 1);
    }

    public void addBook(Book book) {
        book.setId(newId);
        newId++;
        listOfBooks.add(book);
    }

    public void deleteBook(Long id) {
        List<Book>add = books();
        try {
            add
                    .stream()
                    .filter(book -> !book.getId().equals(id))
                    .collect(Collectors.toList()); //zmienić na usuwanie z listy na stałe.

            log.info("delete " + id + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            add
                    .stream()
                    .forEach(System.out::println);

            listOfBooks = add;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            log.info("Index" + id + " out of bounds for length");
        }
    }

    public void updateBook(Book updatedBook, Long id) { //w postmanie sprawdzić.
        List<Book>updateOfBook = books();
        try {
            updateOfBook.stream()
                    .map(book -> {
                        if (book.getId().equals(updatedBook.getId())) {
                            book.setTitle(updatedBook.getTitle());
                            book.setType(updatedBook.getType());
                            book.setPublisher(updatedBook.getPublisher());
                            book.setIsbn(updatedBook.getIsbn());
                            book.setAuthor(updatedBook.getAuthor());
                        }
                        return book;
                    })
                    .collect(Collectors.toList());
            listOfBooks = updateOfBook;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            log.info("Index" + id + " out of bounds for length");
        }
    }

    public List<Book> books() { // w sumie niepotrzebne, zapytać jak wyciągnąć to żeby było dobrze.
        List<Book> books = listOfBooks;
        return books;
    }


}