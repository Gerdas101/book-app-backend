package lt.viko.eif.GJarusevicius.BookApp;

import lt.viko.eif.GJarusevicius.BookApp.Services.BookService;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BookAppApplication {

	public static void main(String[] args){
		SpringApplication.run(BookAppApplication.class, args);
	}
}
