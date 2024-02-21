Feature: Check detail item page functionality

  Background: 
    Given user is on login page
    When user logins susscessful
    Then user is navigated to the home page
    
    Scenario: check open detail item
    When user clicks on link item
    Then detail of item is displayed
    
    Scenario: check add to cart from detail page
    When user clicks on link item
    And user clicks on button Add to cart
    Then button add to cart is changed to remove
    And number of items is displayed corresponding in shopping cart icon
    
