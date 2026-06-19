@login
Feature: Test Login functionality of application

  Scenario Outline: Verify the Login functionality
    Given User enters "<UserName>" and "<Password>"
    Then User should be able to login successfully
    And User add the product into card which having name "Sauce Labs Bolt T-Shirt"
    And Verify User is on Cart page
    Examples:
      | UserName      | Password     |
      | standard_user | secret_sauce |

