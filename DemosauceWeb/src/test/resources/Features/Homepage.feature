Feature: Test homepage functionality

  Background: 
    Given user is on login page
    When user logins susscessful
    Then user is navigated to the home page

  Scenario: check add to cart fucntionality
    When user adds some items to cart
    Then button Add to cart is changed to Remove
    And number of items is displayed corresponding in shopping cart icon

  Scenario: check remove item from Cart
    When user adds item to cart
    And clicks Remove item has just added
    Then button Remove is changed to Add To Cart
    And number of items is displayed corresponding in shopping cart icon

  
