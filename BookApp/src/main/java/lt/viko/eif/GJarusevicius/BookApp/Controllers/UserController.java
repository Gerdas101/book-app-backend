package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class for user endpoints
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/book-app")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Endpoint for retrieving a list of all users
     * @return a list of users
     */
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    /**
     * Endpoint for retrieving information about specified user
     * @param id user's id
     * @return user object
     */
    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id){
        return userService.getById(id);
    }

    /**
     * Endpoint for inserting a new user
     * @param user user object
     */
    @PostMapping("/users")
    public void insertUser(@RequestBody User user){
        userService.insert(user);
    }

    /**
     * Endpoint for updating information about a user
     * @param user user object
     * @param id user id
     */
    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user, id);
    }

    /**
     * Endpoint for deleting a user
     * @param id user id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
