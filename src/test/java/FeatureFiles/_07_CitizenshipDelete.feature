#Senaryo
#CitizenShip sayfas�na gidiniz.
#Create i�lemini parameter y�ntemi ile do�rulay�n�z.
#Daha sonra ayn� bilgilerle tekrar Create yap�lamad���n� do�rulay�n�z. (negatif test)
#olu�turulan her CitizenShip i siliniz.
#yukar�daki senaryoyu farkl� 5 de�er i�in �al��t�r�n�z.

Feature: Citizenship Functionality

  Background: # runs before each scenario

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

    # Scenario Outline: olu�turduk ve hatadan example olu�turu se�tik
  Scenario Outline: Create citizenship
    When Create a citizenship name as "<name>" shortname as "<shortname>"
    Then Success message should be displayed

    When Create a citizenship name as "<name>" shortname as "<shortname>"
    Then Already exist message should be displayed

    When User delete the name "<name>"
    Then Success message should be displayed

    Examples:
      | name            | shortname |
      | CabbarCountry60 | cc60      |
      | CabbarCountry61 | cc61      |
      | CabbarCountry62 | cc62      |
      | CabbarCountry63 | cc63      |
      | CabbarCountry64 | cc64      |


