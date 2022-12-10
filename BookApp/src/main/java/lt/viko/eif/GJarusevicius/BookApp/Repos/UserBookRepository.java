package lt.viko.eif.GJarusevicius.BookApp.Repos;

import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {
}
