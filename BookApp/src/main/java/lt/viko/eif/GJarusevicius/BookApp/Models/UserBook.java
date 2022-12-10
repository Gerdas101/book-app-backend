package lt.viko.eif.GJarusevicius.BookApp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * UserBook model class
 */
@Entity
public class UserBook{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int pagesRead;
    private String notes;
    private boolean isFinished;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public UserBook() {
    }
    public UserBook(int pagesRead, String notes, boolean isFinished, User user, Book book) {
        this.pagesRead = pagesRead;
        this.notes = notes;
        this.isFinished = isFinished;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getPagesRead() {
        return pagesRead;
    }
    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}
