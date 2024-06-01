@ikea
Feature: Ikea Test

    @ikea_obj
    Scenario: Ikea
        Given I go to Ikea page
        Then I search for "sofa" in store
        Then I add item to cart
        Then I go to search bar at the top of the page to enter "table"
        Then I add item to a cart
        Then I open cart
        Then I validate that two items in cart
        When I enter discount code "code1234567890!" to apply
        Then I validate that "Something went wrong, please try again in a moment." but error message is displayed
