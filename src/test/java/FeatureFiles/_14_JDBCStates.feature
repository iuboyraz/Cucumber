# States men�s�nden gelen ilk 10 verinin DB deki data ile ayn� olup olmad���n�n kontrol�

Feature: Testing database of States functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

    Scenario: Testing database of States functionality using JDBC
    And Click on the element in the LeftNav
      | setup      |
      | parameters |
      | states     |
    Then Send the "select name from states limit 10" query to the Database and check if it matches with UI