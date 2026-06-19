Feature: Test wiremock server

  @APITest
  Scenario: Generating API response using wiremock server
    Given Start the WireMock server
    And I send a GET request to "/api/users/1"
    And Validate the response body
