package service;

import constants.Endpoints;
import models.payments.AddFundsRequest;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class PaymentService extends RestService {

    public PaymentService(Cookies cookies) {

        super(cookies);
    }

    public Response getFunds(AddFundsRequest body) {
        return given()
                .spec(REQ_SPEC)
                .body(body)
                .post(Endpoints.ADD_FUNDS);
    }

    public Response getPayments() {
        return given()
                .spec(REQ_SPEC)
                .get(Endpoints.PAYMENTS);
    }
}
