package service;

import constants.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import models.register.RegisterUserRequest;
import models.update.UpdatePersonalDataRequest;
import static io.restassured.RestAssured.given;

public class UserService extends RestService {

    public Response currentResponse;

    public UserService(Cookies cookies) {

        super(cookies);
    }

    public Response registerPlayer(RegisterUserRequest body) {
        return given()
                .spec(REQ_SPEC)
                .body(body)
                .post(Endpoints.REGISTRATION);
    }

    public Response updatePlayer(UpdatePersonalDataRequest body) {
        return given()
                .spec(REQ_SPEC)
                .body(body)
                .post(Endpoints.UPDATE_PERSONAL_DATA);
    }

    public Response getBalance() {
        return given()
                .spec(REQ_SPEC)
                .contentType(ContentType.TEXT)
                .get(Endpoints.BALANCE);
    }

}
