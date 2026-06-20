@login
Feature: Test Login & add product functionality of application

  Scenario Outline: Verify the user is able to Login & add product
    Given User enters "<UserName>" and "<Password>"
    Then User should be able to login successfully
    And User add the product into card which having name "<product>"
    And Verify the "<product>" is added into cart
    And User Clicks on Checkout button from cart page
    Examples:
      | UserName      | Password     | product           |
      | standard_user | secret_sauce | Sauce Labs Onesie |

