package se1app.applicationcore.facade;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.http.HttpStatus;
import se1app.applicationcore.Application;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.customercomponent.Reservation;
import se1app.applicationcore.moviecomponent.Movie;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ApplicationFacadeControllerTest {

    @LocalServerPort
    int port;
    
    @Autowired
    private CustomerRepository customerRepository;

    private Customer mickey;
    private Customer minnie;
    private Customer pluto;

    @Before
    public void setUp() {
        customerRepository.deleteAll();

        mickey = new Customer("Mickey Mouse");
        minnie = new Customer("Minnie Mouse");
        pluto = new Customer("Pluto");
        customerRepository.save(Arrays.asList(mickey, minnie, pluto));

        RestAssured.port = port;
    }

    @Test
    public void testGetSingleSuccess() {
        Integer mickeyId = mickey.getId();

        when().
                get("/customers/{id}", mickeyId).
                then().
                statusCode(HttpStatus.OK.value()).
                body("name", is("Mickey Mouse")).
                body("id", is(mickeyId));
    }

    @Test
    public void testGetSingleFail() {
        Integer mickeyId = Integer.MAX_VALUE;

        when().
                get("/customers/{id}", mickeyId).
                then().
                statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testGetAllSuccess() {
        when().
                get("/customers").
        then().
                statusCode(HttpStatus.OK.value()).
                body("name", hasItems("Mickey Mouse", "Minnie Mouse", "Pluto"));
    }

    @Test
    public void testDeleteSuccess() {
        Integer plutoId = pluto.getId();

        when().
                delete("/customers/{id}", plutoId).
        then().
                statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void testCreateSuccess() {
        Customer donald = new Customer("Donald Duck");

        given().
                contentType("application/json").
                body(donald).
                expect().
                statusCode(HttpStatus.CREATED.value()).
        when().
                post("/customers");
    }

    @Test
    public void testUpdateSuccess() {
        Customer trick = new Customer("Trick");

        trick = given().
                contentType("application/json").
                body(trick).
                expect().
                statusCode(HttpStatus.CREATED.value()).
        when().
                post("/customers").as(Customer.class);

        trick.setName("Track");
        given().
                contentType("application/json").
                body(trick).
                expect().
                statusCode(HttpStatus.OK.value()).
        when().
                put("/customers");
        when().
                get("/customers/{id}", trick.getId()).
        then().
                statusCode(HttpStatus.OK.value()).
                body("name", is("Track"));
    }

    @Test
    public void testAddReservationSuccess() {
        Integer mickeyId = mickey.getId();

        when().
                get("/movies/007").
        then().
                statusCode(HttpStatus.NOT_FOUND.value());

        Movie movie007 = new Movie("007");
        Reservation movieReservation007 = new Reservation(movie007);
        given().
                contentType("application/json").
                body(movieReservation007).
        expect().
                statusCode(HttpStatus.CREATED.value()).
        when().
                post("/customers/{id}/reservations", mickeyId);
        when().
                get("/movies/007").
        then().
                statusCode(HttpStatus.OK.value()).
                body(equalTo("1"));
   }
}