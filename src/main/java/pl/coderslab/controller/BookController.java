//package pl.coderslab.controller;
//
//import org.springframework.web.bind.annotation.*;
//import pl.coderslab.Book;
//import pl.coderslab.MemoryBookService;
//import pl.coderslab.interfejs.BookService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/books")
//public class BookController implements BookService{
//
//    private BookService bookService;
//    private MemoryBookService memoryBookService;
//
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        return new Book(1L, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//    }
//
//    @GetMapping("/start")
//    public @ResponseBody
//    List<Book> getList() {
//        return memoryBookService.getList();
//    }
////
////    @GetMapping("/{id}")
////    public Book showBookById(@PathVariable Long id) {
////        return memoryBookService.showBookById(id);
////    }
////
////    @PostMapping("")
////    public void addBook(@RequestBody Book book) {
////        memoryBookService.addBook(book);
////    }
////
////
////    @DeleteMapping("/{id}")
////    public void deleteBookById(@PathVariable Long id) {
////        memoryBookService.deleteBook(id);
////    }
////
////
////    @PutMapping("")
////    public void deleteBook(@RequestBody Book updatedBook) {
////        memoryBookService.updateBook(updatedBook);
////    }
//
//
//
//
//
//
//
//
//
//    /////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public List<Book> getBooks() {
//        return null;
//    }
//
//    @Override
//    public Book get(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Book> getBookList() {
//        return null;
//    }
//
//    @Override
//    public void add(Book book) {
//
//    }
//
//    @Override
//    public void update(Book book) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}
///////////////////////////////////////////////////////////////

package pl.coderslab.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import pl.coderslab.MemoryBookService;


import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);


    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook") //na koniec do usunięcia
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> getList() {
        log.info("All books  111111111111111111");
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book BookId(@PathVariable Long id) {
        return memoryBookService.BookId(id);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        memoryBookService.addBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        memoryBookService.deleteBook(id);
    }


    @PutMapping("/update")
    public void updateBook(@RequestBody Book updatedBook) {
        memoryBookService.updateBook(updatedBook, updatedBook.getId());// nie działa
    }

}


