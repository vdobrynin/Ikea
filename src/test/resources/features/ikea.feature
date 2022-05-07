@ikea
  Feature: Ikea Test Suite

    @ikea_obj_1
    Scenario: Ikea Search Bar
      Given I go to "ikea" page
      Then I go to input box "What are you looking for?"
      And I search for "sofa" in store