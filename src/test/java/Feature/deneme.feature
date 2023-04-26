Feature: login functionality

  Scenario: scenario login

    Given user on "https:/...."
    When  user click Login-Sign button
    And   user login with the following credentials
      | username | atezgider@gmail.com |
      | password | ahmet123            |
    Then  login should be successfull