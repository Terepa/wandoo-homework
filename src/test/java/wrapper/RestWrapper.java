package wrapper;

import constants.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import models.register.RegisterUserRequest;
import service.PaymentService;
import service.UserService;

import static io.restassured.RestAssured.given;

public class RestWrapper {

    private Cookies cookies;
    public UserService user;
    public PaymentService payment;

    private RestWrapper(Cookies cookies){
        this.cookies = cookies;
        user = new UserService(cookies);
        payment = new PaymentService(cookies);

    }

    public static RestWrapper signIn(RegisterUserRequest body) {
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(Endpoints.BASE_URL)
                .body(body)
                .post()
                .getDetailedCookies();
        return new RestWrapper(cookies);
    }
}
