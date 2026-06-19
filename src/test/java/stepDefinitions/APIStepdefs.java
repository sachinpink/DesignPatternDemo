package stepDefinitions;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class APIStepdefs {
    private WireMockServer wireMockServer;
    static Response response;

    @Given("Start the WireMock server")
    public void startTheWireMockServer()
    {
        wireMockServer =new WireMockServer(8080);
        wireMockServer.start();
       // RestAssured.baseURI="http://localhost:8080";
        wireMockServer.stubFor(get(urlEqualTo("/api/users/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": 1, \"name\": \"John Doe\"}")));
    }

    @And("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint)
    {
        response=RestAssured.given().when().get(endpoint).then().log().all().extract().response();

    }

    @And("Validate the response body")
    public void validateTheResponseBody()
    {
        JsonPath path =new JsonPath(response.asString());
        int id = path.get("id");
        String fullName = path.getString("name");
        Assert.assertEquals(fullName,"John Doe");

    }
}
