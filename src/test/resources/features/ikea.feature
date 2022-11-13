@ikea
Feature: Ikea Test

  @ikea_obj_1
  Scenario: Ikea
    Given I go to "ikea" page
    And I search for "sofa" in store
    Then I add item to cart
    Then I go to search bar at the top of the page to enter "table"
    Then I search for "table" at store
    Then I add item to a cart
    Then I open cart
    And I validate that two items in cart
    When I enter discount code "code1234567890!" to apply
    Then I validate that "You've added an invalid coupon code. Please try again." but error message is displayed