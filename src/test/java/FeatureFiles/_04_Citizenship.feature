#Senaryo
#Citizenship sayfas�na gidiniz.
#1 adet citizenship kayd� yap�labildi�ini do�rulay�n�z.

Feature: Citizenship Functionality

  Scenario: Create a citizenship

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship
    When Create a citizenship
    Then Success message should be displayed
