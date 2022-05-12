@ikea
Feature: Ikea Test Suite

  @ikea_obj_1
  Scenario: Ikea Search Bar
    Given I go to "ikea" page
    When I go to input box "what are you looking for?"
    And I search for "sofa" in store
    And On product page I find "first" item
    Then I add item "uppland" to cart
    Then I search for "table" in store
    And On page I find "third" item
    Then I add item "jokkmokk" to cart
    Then I open cart
    And I validate that two items in cart
    When I enter discount code "code1234567890!" to apply
    Then I validate that "You've added an invalid coupon code. Please try again." but error message is displayed