@ikea
Feature: Ikea Test Suite

  @ikea_obj_1
  Scenario: Ikea Search Bar
    Given I go to "ikea" page
    Then I go to input box "what are you looking for?"
    And I search for "sofa" in store
    And On product page I find "first" item
    Then I add item "uppland" to cart
    And I search for "table" in store
    And On product page I find "third" item
    Then I add item "table" to cart
    Then I open cart and
    And validate two items in cart
    Then I enter discount code to apply
    Then I validate that "invalid coupon code" but error message is displayed