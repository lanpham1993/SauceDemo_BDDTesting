Feature: feature to test login functionality


  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |

@invalidCase
  Scenario: Check login is failed with invalid credentials
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then Error will be displayed
    
     Examples: 
      | username      | password     |
      | locked_out_user | secret_sauce |
