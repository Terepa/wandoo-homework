package service;

import constants.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;

public abstract class RestService {
    protected RequestSpecification REQ_SPEC;
    protected Cookies cookies;

    public RestService(Cookies cookies) {
        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(Endpoints.BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
