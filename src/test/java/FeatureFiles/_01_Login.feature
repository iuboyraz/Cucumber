#Login kontrol senaryosu
#siteye git,
#login bilgilerini gir,
#giri� yapt���n� do�rula.

  Feature: Login functionality

    @Smoke
    Scenario: Login with valid username and password

      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully