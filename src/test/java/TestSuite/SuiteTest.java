package TestSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.URL_Dev;

public class SuiteTest {

    public static Cookies cookies;
    public static RequestSpecification spec;

    @BeforeClass
    public static void Login() {
        spec = new RequestSpecBuilder()
                .setBaseUri(URL_Dev)
                .setBasePath("/api/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();

        cookies = given()
                .baseUri(URL_Dev)
                .urlEncodingEnabled(true)
                .param("email", "zenio@zensoft.io")
                .param("password", "12345678")
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .response()
                .getDetailedCookies();
    }
}
