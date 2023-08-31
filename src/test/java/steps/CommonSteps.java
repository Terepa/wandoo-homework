package steps;

import models.balance.BalanceResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.payments.AddFundsRequest;
import io.restassured.response.Response;
import models.payments.ResponseList;
import models.register.*;
import models.update.UpdatePersonalDataRequest;
import models.update.UpdatePersonalDataResponse;
import wrapper.RestWrapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CommonSteps {

    private static RestWrapper api;
    private UpdatePersonalDataRequest updatePersonalDataRequest;
    public static Response currentResponse;

    @Given("^get cookies$")
    public static void signIn() {

        api = RestWrapper.signIn(new RegisterUserRequest());
    }

    @And("^server status code is (\\d+)$")
    public void serverStatusCodeIs(int statusCode) {
            currentResponse.then().statusCode(statusCode);
    }

    @When("^user make POST request for endpoint sign-up$")
    public void userMakePOSTRequestForEndpointSignup() {
        RegisterUserRequest registerPlayerRequest = new RegisterUserRequest();
        currentResponse = api.user.registerPlayer(registerPlayerRequest);
        currentResponse.then().log().all();
    }

    @Then("^server response for sign-up body matches api documentation$")
    public void serverResponseForSignUpBodyMatchesApiDocumentation() {
        RegistrationResponse registrationResponse = currentResponse.then().extract().as(RegistrationResponse.class);
        UserDetails user = registrationResponse.getUser();
        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getEmail(), equalTo(registrationResponse.getUser().getEmail()));
        MessageDetails messageDetails = registrationResponse.getMessage();
        assertThat(messageDetails.getMessage(), equalTo("User registered"));
        assertThat(messageDetails.getStatus(), equalTo("SUCCESS"));
    }

    @When("^user make POST request for endpoint personal-data$")
    public void userMakePOSTRequestForEndpointPersonalData() {
        updatePersonalDataRequest = new UpdatePersonalDataRequest();
        currentResponse = api.user.updatePlayer(updatePersonalDataRequest);
        currentResponse.then().log().all();
    }

    @Then("^server response for personal-data update matches api documentation$")
    public void serverResponseForPersonalDataUpdateMatchesApiDocumentation() {
        UpdatePersonalDataResponse updatePersonalDataResponse = currentResponse.then().extract().as(UpdatePersonalDataResponse.class);
        UserDetails user = updatePersonalDataResponse.getUser();
        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getEmail(), is(notNullValue()));
        assertThat(user.getFirstName(), equalTo(updatePersonalDataRequest.getFirstName()));
        assertThat(user.getSurname(), equalTo(updatePersonalDataRequest.getSurname()));
        assertThat(user.getPersonalId(), equalTo(updatePersonalDataRequest.getPersonalId()));
        MessageDetails messageDetails = updatePersonalDataResponse.getMessage();
        assertThat(messageDetails.getMessage(), equalTo("Personal info updated"));
        assertThat(messageDetails.getStatus(), equalTo("SUCCESS"));
    }

    @When("^user make GET request for endpoint balance$")
    public void userMakeGETRequestForEndpointBalance() {
        currentResponse = api.user.getBalance();
        currentResponse.then().log().all();
    }

    @Then("^server response for balance body matches api documentation$")
    public void serverResponseForBalanceBodyMatchesApiDocumentation() {
        BalanceResponse balanceResponse = currentResponse.then().extract().as(BalanceResponse.class);
        assertThat(balanceResponse.getBalance(), is(instanceOf(double.class)));
    }

    @When("^user make POST request for endpoint add-funds$")
    public void userMakePOSTRequestForEndpointAddFunds() {
        AddFundsRequest addFundsRequest = new AddFundsRequest();
        currentResponse = api.payment.getFunds(addFundsRequest);
        currentResponse.then().log().all();
    }

    @Then("^server response for add-funds body matches api documentation$")
    public void serverResponseForAddFundsBodyMatchesApiDocumentation() {
        String addFundsResponse = currentResponse.then().extract().asString();
        assertThat(addFundsResponse, containsString("Payment imported, id:"));
    }

    @When("^user make GET request for endpoint payments$")
    public void userMakeGETRequestForEndpointPayments() {
        currentResponse = api.payment.getPayments();
        currentResponse.then().log().all();
    }

    @Then("^server response for payments body matches api documentation$")
    public void serverResponseForPaymentsBodyMatchesApiDocumentation() {
        ResponseList paymentsResponse = currentResponse.then().extract().as(ResponseList.class);
        assertThat(paymentsResponse.get(0).getType() , containsString("FUNDING"));
    }
}

