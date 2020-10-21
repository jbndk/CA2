package rest;

import dto.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import java.net.URI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
//Uncomment the line below, to temporarily disable this test
@Disabled

public class PersonResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Person p1, p2, p3;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //System.in.read();
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the EntityClass used below to use YOUR OWN (renamed) Entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        p1 = new Person("mf@ft.dk", "Mette", "Frederiksen");
        Address a1 = new Address("Nørrebrogade 1", "privat");
        CityInfo c1 = new CityInfo("2200", "København N");
        Phone ph1 = new Phone(12345678, "mobil");
        Hobby h1 = new Hobby("wiki", "Akvarie", "fisk", "kedeligt");

        a1.setCityinfo(c1);
        p1.setAddress(a1);
        p1.addHobby(h1);
        p1.addTelNo(ph1);

        p2 = new Person("scn@ft.dk", "Sofie Carsten", "Nielsen");
        Address a2 = new Address("Amagerbrogade 1", "hjem");
        CityInfo c2 = new CityInfo("2300", "København S");
        Phone ph2 = new Phone(11223344, "hjemme");
        Hobby h2 = new Hobby("link", "Dans", "indendørs", "whatever");

        a2.setCityinfo(c2);
        p2.setAddress(a2);
        p2.addHobby(h2);
        p2.addTelNo(ph2);

        p3 = new Person("sp@ft.dk", "Søren", "Pape");
        Address a3 = new Address("Esplanaden 33", "hjem");
        CityInfo c3 = new CityInfo("1015", "København K");
        Phone ph3 = new Phone(55446688, "kontor");
        Hobby h3 = new Hobby("wikilink", "Domino", "spil", "stille");

        a3.setCityinfo(c3);
        p3.setAddress(a3);
        p3.addHobby(h3);
        p3.addTelNo(ph3);
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.createNamedQuery("Address.deleteAllRows").executeUpdate();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testServerIsUp() {
        System.out.println("Testing is server UP");
        given().when().get("/person").then().statusCode(200);
    }

    //This test assumes the database contains two rows
    @Test
    public void testDummyMsg() throws Exception {
        given()
                .contentType("application/json")
                .get("/person/").then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("msg", equalTo("API is running"));
    }

    @Test
    public void testCount() throws Exception {
        given()
                .contentType("application/json")
                .get("/person/count").then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("count", equalTo(3));
    }

    @Test
    public void getAllPersons() {
        List<PersonDTO> personsDTOs;

        personsDTOs = given()
                .contentType("application/json")
                .when()
                .get("/person/all")
                .then()
                .extract().body().jsonPath().getList("all", PersonDTO.class);

        PersonDTO p1DTO = new PersonDTO(p1);
        PersonDTO p2DTO = new PersonDTO(p2);
        PersonDTO p3DTO = new PersonDTO(p3);

        assertThat(personsDTOs, containsInAnyOrder(p1DTO, p2DTO, p3DTO));
    }

    /*
    @Test
    public void addPerson() {
        given()
                .contentType(ContentType.JSON)
                .body(new PersonDTO("bg@ms.com", "Bill", "Gates", "Strandvejen 1", "2900", "Skak", 1234)
                        .when()
                        .post("person")
                        .then()
                        .body("email", equalTo("bg@ms.com"))
                        .body("fName", equalTo("Bill"))
                        .body("lName", equalTo("Gates"))
                        .body("street", equalTo("Strandvejen 1"))
                        .body("zip", equalTo("2900"))
                        .body("hobbyName", equalTo("Skak"))
                        .body("phNumber", equalTo(1234)));
    }

    @Test
    public void updatePerson() {
        PersonDTO person = new PersonDTO(p1);
        person.setPhone("456");

        given()
                .contentType(ContentType.JSON)
                .body(person)
                .when()
                .put("person/" + person.getId())
                .then()
                .body("fName", equalTo("Claes"))
                .body("lName", equalTo("Lindholm"))
                .body("phone", equalTo("456"))
                .body("id", equalTo((int) person.getId()));
    }

    @Test
    public void testDelete() throws Exception {

        PersonDTO person = new PersonDTO(p1);

        given()
                .contentType("application/json")
                .delete("/person/" + person.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode());

        List<PersonDTO> personsDTOs;

        personsDTOs = given()
                .contentType("application/json")
                .when()
                .get("/person/all")
                .then()
                .extract().body().jsonPath().getList("all", PersonDTO.class);

        PersonDTO p2DTO = new PersonDTO(p2);
        PersonDTO p3DTO = new PersonDTO(p3);

        assertThat(personsDTOs, containsInAnyOrder(p2DTO, p3DTO));

    }*/
}
