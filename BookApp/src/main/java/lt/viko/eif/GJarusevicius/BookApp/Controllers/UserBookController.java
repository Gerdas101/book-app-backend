package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import lt.viko.eif.GJarusevicius.BookApp.Services.BookService;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserBookService;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class for UserBooks endpoints
 */

@RestController
@RequestMapping("/book-app")
public class UserBookController {

    UserService userService;
    UserBookService userBookService;
    BookService bookService;

    @Autowired
    UserBookController(UserService userService, UserBookService userBookService, BookService bookService){
        this.userService = userService;
        this.userBookService = userBookService;
        this.bookService = bookService;
    }

    /**
     * Endpoint for retrieving a list of saved books by user
     * @param userId user's id
     * @return a list of books
     */
    @GetMapping("/users/{userId}/userbooks")
    public List<UserBook> getUserBooks(@PathVariable Long userId){
        return userBookService.getUserBook(userId);
    }

    /**
     * Endpoint for inserting a book to user's books list
     * @param userId id of a user
     * @param pagesRead number of pages read
     * @param notes notes about a book
     * @param book a book to be inserted
     */
    @PostMapping("/users/{userId}/userbooks")
    public void insertUserBook(@PathVariable Long userId,
                           @RequestParam("pagesRead") int pagesRead,
                           @RequestParam("notes") String notes,
                           @RequestBody Book book){
        boolean isFinished;
        isFinished = pagesRead >= book.getPages();

        User user = userService.getById(userId);
        Book book1 = bookService.findBookById(book.getId());
        if(book1 == null){
            bookService.insert(book);
        }
        UserBook userBook = new UserBook(pagesRead, notes, isFinished, user, book);
        userBookService.saveUserBook(userBook);
    }

    /**
     * Endpoint for updating notes and pages read of a book
     * @param userId user's id
     * @param userBookId user's book id
     * @param pagesRead number of pages read
     * @param notes notes about a book
     */
    @PutMapping("/users/{userId}/userbooks/{userBookId}")
    public void updateUserBook(@PathVariable Long userId,
                               @PathVariable int userBookId,
                               @RequestParam("pagesRead") int pagesRead,
                               @RequestParam("notes") String notes){
        userBookService.updateUserBook(userBookId, userId, pagesRead, notes);
    }

    /**
     * Endpoint for deleting a book from user's book list
     * @param userBookId id of a userBook
     * @param userId id of a user
     */
    @DeleteMapping("/users/{userId}/userbooks/{userBookId}")
    public void deleteUserBook(@PathVariable int userBookId,
                               @PathVariable Long userId){
        userBookService.deleteUserBook(userBookId, userId);
    }



}
