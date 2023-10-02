#Excelden okuduðunuz citizenship bilgilerini
#  önce kaydedin
#  sonra silin.

Feature: Citizenship Functionality (POI usage)

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

    Scenario: Create and Delete citizenship from excel
      When User create citizenship with ApachePOI
      Then User delete citizenship with ApachePOI