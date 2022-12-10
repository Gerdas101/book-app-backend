package lt.viko.eif.GJarusevicius.BookApp;

import com.squareup.okhttp.Request;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.*;
import org.junit.Assert;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import okhttp3.*;
import okio.*;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBooksStep {

    private OkHttpClient client = new OkHttpClient();
    private Response response;
    
    @When("The user sends a request to Book endpoint")
    public void theUserSendsARequestToBookEndpoint() {
        try {
            Request request = new Request.Builder()
                    .url("http://localhost:8080/books/")
                    .get()
                    .build();

            this.response = client.newCall(request).execute();
        } catch (Exception e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
        }
    }

    @Then("A list of saved books is displayed")
    public void aListOfSavedBooksIsDisplayed() {
        Assert.assertEquals(200, response.code());
    }
}
