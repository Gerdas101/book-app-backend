package lt.viko.eif.GJarusevicius.BookApp.Services;

import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserBookRepository;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserBook service class
 */
@Service
public class UserBookService {

    UserBookRepository userBookRepository;
    UserRepository userRepository;

    @Autowired
    UserBookService(UserBookRepository userBookRepository, UserRepository userRepository){
        this.userBookRepository = userBookRepository;
        this.userRepository = userRepository;
    }

    /**
     * Method for retrieving a list of user books from database
     * @param userId user id
     * @return a list of user books
     */
    public List<UserBook> getUserBook(long userId){
        User user = userRepository.findById(userId).get();
        List<UserBook> userBooks = user.getUserBooks();
        return userBooks;
    }

    /**
     * Method for saving a userBook to a user's book list
     * @param userBook userBook object to be saved
     */
    public void saveUserBook(UserBook userBook){
        userBookRepository.save(userBook);
    }

    /**
     * Method for updating information about userBook
     * @param userBookId id of a userBook
     * @param userId id of a user
     * @param pagesRead number of pages that have been read
     * @param notes notes about a book
     */
    public void updateUserBook(int userBookId, Long userId, int pagesRead, String notes){
        List<UserBook> userBooks = getUserBook(userId);
        UserBook originalUserBook = userBooks.stream().filter(userBook1 -> userBook1.getId() == userBookId).findFirst().get();
        originalUserBook.setPagesRead(pagesRead);
        originalUserBook.setNotes(notes);
        userBookRepository.save(originalUserBook);
    }

    /**
     * Method for deleting a userBook from database of specified user books list
     * @param userBookId userBook id
     * @param userId user id
     */
    public void deleteUserBook(int userBookId, Long userId){
        List<UserBook> userBooks = getUserBook(userId);
        UserBook userBook = userBooks.stream().filter(userBook1 -> userBook1.getId() == userBookId).findFirst().get();
        userBookRepository.delete(userBook);
    }
}
