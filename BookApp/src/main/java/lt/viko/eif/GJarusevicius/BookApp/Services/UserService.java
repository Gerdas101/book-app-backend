package lt.viko.eif.GJarusevicius.BookApp.Services;

import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service class
 */
@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Method for retrieving all users from database
     * @return a list of users
     */
    public List<User> getAll(){
        return userRepository.findAll();
    }

    /**
     * Method for retrieving user information from database
     * @param id user id
     * @return user object
     */
    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    /**
     * Method for inserting a new user to a database
     * @param user user object to be inserted
     */
    public void insert(User user){
        userRepository.save(user);
    }

    /**
     * Method for updating a user information
     * @param user user object
     * @param id user id
     */
    public void updateUser(User user, Long id){
        User originalUser = userRepository.findById(id).get();
        originalUser.setUsername(user.getUsername());
        originalUser.setPassword(user.getPassword());
        userRepository.save(originalUser);
    }

    /**
     * Method for deleting a user from database
     * @param id user id
     */
    public void deleteUser(Long id){
        userRepository.delete(this.getById(id));
    }
}
