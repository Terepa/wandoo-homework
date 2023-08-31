
@SmokeTest

Feature: Smoke API test

  Scenario: Get Cookies | Sign-up | Update personal data | Check user balance | Add founds | Check payments

    Given get cookies

    When user make POST request for endpoint sign-up
    And  server status code is 200
    Then server response for sign-up body matches api documentation

    When user make POST request for endpoint personal-data
    And  server status code is 201
    Then server response for personal-data update matches api documentation

    When user make GET request for endpoint balance
    And  server status code is 200
    Then server response for balance body matches api documentation

    When user make POST request for endpoint add-funds
    And server status code is 200
    Then server response for add-funds body matches api documentation

    When user make GET request for endpoint payments
    And  server status code is 200
    Then server response for payments body matches api documentation

