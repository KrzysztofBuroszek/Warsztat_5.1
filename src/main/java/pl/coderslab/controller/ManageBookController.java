package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import pl.coderslab.interfejs.BookService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;


    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        System.out.println(books);
        return "admin/books/all";
    }


    @GetMapping(value = "/bookId", params = "id")
    public String get(@RequestParam Long id, Model model) {
        Optional<Book> book = bookService.get(id);
        boolean present = book.isPresent();

        if (present) {

            String author = book.get().getAuthor();
            String title = book.get().getIsbn();
            String isbn = book.get().getTitle();
            String idBook = String.valueOf(book.get().getId());

            model.addAttribute("idBook", idBook);
            model.addAttribute("title", title);
            model.addAttribute("author", author);
            model.addAttribute("isbn", isbn);

            return "admin/books/get";
        }
        return "admin/books/get";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "admin/books/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST) //*
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }


    @GetMapping("/show/{id}")
    public String showeBook(Model model, @PathVariable(value = "id") long id) {
        Optional<Book> book = bookService.get(id);
        boolean present = book.isPresent();

        if (present) {

            String author = book.get().getAuthor();
            String title = book.get().getIsbn();
            String isbn = book.get().getTitle();
            String idBook = String.valueOf(book.get().getId());

            model.addAttribute("idBook", idBook);
            model.addAttribute("title", title);
            model.addAttribute("author", author);
            model.addAttribute("isbn", isbn);

            return "admin/books/get";
//            return "ok";
        }
        return "admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable(value = "id") long id) {
        Optional<Book> book = bookService.get(id);
        boolean present = book.isPresent();

        if (present) {
            model.addAttribute("bookEdit", bookService.get(id));
            return "admin/books/edit";
        }
        return "admin/books/edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }



}


