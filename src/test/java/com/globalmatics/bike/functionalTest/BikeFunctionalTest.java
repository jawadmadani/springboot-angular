package com.globalmatics.bike.functionalTest;

import com.globalmatics.bike.BikeApplication;
import com.globalmatics.bike.models.Bike;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BikeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BikeFunctionalTest {


    @LocalServerPort
    private String serverPort;

    String bikeUrl;


    @Before
    public void setUp() {
        bikeUrl = String.format("http://localhost:%s/api/v1/bikes", serverPort);
    }

    @Test
    public void testingToCreateABike() {

//        creating a bike and testing it.
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(createBikeBode()).
        when().
                post(bikeUrl + "/create").
        then().
                statusCode(201);
    }

     @Test
    public void testingToFetchABike() {

//        creating a bike and then extracting it's id.
        long id =
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(createBikeBode()).
        when().
                post(bikeUrl + "/create").
        then().
                extract().response().as(Bike.class).getId();

//        testing
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(createBikeBode()).
        when().
                get(bikeUrl + "/" + id).
        then().
                statusCode(200).
        and().
                body("name", equalTo("Jawad"));

    }


    @Test
    public void testingToDeleteBikes() {

//        creating a bike and then extracting it's name.
        String name =
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(createBikeBode()).
        when().
                post(bikeUrl + "/create").
        then().
                extract().response().as(Bike.class).getName();

//        testing
        given().
                contentType(ContentType.JSON).
                contentType(ContentType.JSON).
        when().
                delete(bikeUrl + "/" + name).
        then().
                statusCode(200);

    }


    private String createBikeBode() {
        return "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Jawad\",\n" +
                "    \"email\": \"jawad@bikes.com\",\n" +
                "    \"phone\": \"563-345-3456\",\n" +
                "    \"model\": \"Globo Time Trial Blade\",\n" +
                "    \"serialNumber\": null,\n" +
                "    \"purchasePrice\": 2100,\n" +
                "    \"purchaseDate\": \"2014-10-24\",\n" +
                "    \"contact\": true\n" +
                "}";
    }
}
