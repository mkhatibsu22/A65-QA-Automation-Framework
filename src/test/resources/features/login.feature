Feature: Login feature

  Scenario: Login with valid credentials

    Given I am in the Login Page
    And I enter registered email "mohamed.khatib@testpro.io"
    And I enter valid password "ZWyxkAKX"
    When I click submit button
    Then I must be logged in successfully
    