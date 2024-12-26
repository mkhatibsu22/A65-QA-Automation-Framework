Feature: Login feature

  Scenario: Login with valid credentials

    Given I am in the Login Page
    And I enter registered email
    And I enter valid password
    When I click submit button
    Then I must be logged in successfully
    