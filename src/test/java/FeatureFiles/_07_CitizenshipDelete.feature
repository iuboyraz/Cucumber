#Senaryo
#CitizenShip sayfasýna gidiniz.
#Create iþlemini parameter yöntemi ile doðrulayýnýz.
#Daha sonra ayný bilgilerle tekrar Create yapýlamadýðýný doðrulayýnýz. (negatif test)
#oluþturulan her CitizenShip i siliniz.
#yukarýdaki senaryoyu farklý 5 deðer için çalýþtýrýnýz.

Feature: Citizenship Functionality

  Background: # runs before each scenario

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

    # Scenario Outline: oluþturduk ve hatadan example oluþturu seçtik
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


