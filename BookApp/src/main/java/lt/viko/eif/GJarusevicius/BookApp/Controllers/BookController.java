package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Repos.BookRepository;
import lt.viko.eif.GJarusevicius.BookApp.Services.BookService;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * A class for Book endpoints
 */
@RestController
@RequestMapping("/book-app")
public class BookController {

    BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    /**
     * Endpoint for searching for a book with specified title
     * @param title the title of a book
     * @return a list of books with a selected title
     * @throws IOException
     * @throws ParseException
     * @throws InterruptedException
     */
    @GetMapping("/books/search")
    public List<Book> getBooks(@RequestParam("title") String title) throws IOException, ParseException, InterruptedException {
        return bookService.getBooksByTitle(title);
    }

    /**
     * Endpoint for displaying a list of books that have been saved at least once
     * @return a list of saved books
     */
    @GetMapping("/users/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
