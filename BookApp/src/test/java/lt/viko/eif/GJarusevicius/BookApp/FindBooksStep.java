package lt.viko.eif.GJarusevicius.BookApp;

import ch.qos.logback.core.net.server.Client;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FindBooksStep {

    HttpResponse response;
    HttpClient client = HttpClient.newHttpClient();

    @When("The user sends a request to Google API")
    public void theUserSendsARequestToGoogleAPI() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=intitle:The-Man-and-the-sea&orderBy=relevance&maxResults=40&key=AIzaSyDS02M7sB-rHBRgyFi1sO9JHAbBITe1eew"))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Then("A list of books is displayed")
    public void aListOfBooksIsDisplayed() {
        Assert.assertEquals(200, response.statusCode());
    }
}
