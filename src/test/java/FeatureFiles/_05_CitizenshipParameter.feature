#Senaryo
#CitizenShip sayfasýna gidiniz.
#Create iþlemini parameter yöntemi ile doðrulayýnýz.
#Daha sonra ayný bilgilerle tekrar create yapýlamadýðýný doðrulayýnýz. (negatif test)

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