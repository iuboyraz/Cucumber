Feature: Country Multi Scenario

  Background: # runs before each scenario

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario: Create country
    When Create a country
    Then Success message should be displayed

  Scenario: Create country 2
    When Create a country name as "CabbarU1" code as "C1"
    Then Success message should be displayed