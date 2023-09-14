#Senaryo
#CitizenShip sayfas�na gidiniz.
#Create i�lemini parameter y�ntemi ile do�rulay�n�z.
#Daha sonra ayn� bilgilerle tekrar create yap�lamad���n� do�rulay�n�z. (negatif test)

Feature: Citizenship Functionality

  Background: # runs before each scenario

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario: Create citizenship
    When Create a citizenship name as "CabbarCountry59" shortname as "cc59"
    Then Success message should be displayed

  Scenario: Create citizenship 3
    When Create a citizenship name as "CabbarCountry59" shortname as "cc59"
    Then Already exist message should be displayed