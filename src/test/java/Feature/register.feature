Feature: register functionality

  Scenario: scenario register

    Given user on "https:/...."
    When  user click Login-Sign button
    And   New User Signup with the following credentials
      | name  | Moon123               |
      | email | MoonLigth01@gmail.com |
    Then   Signup should be successfull

    When the user enters their details
      | First name    | Ahmet          |
      | Last name     | Yazici         |
      | Company       | ABC LTD.       |
      | Address       | Turkey         |
      | Address2      | Ankara         |
      | Country       | Singapore     |
      | State         | Merkez         |
      | City          | Ankara         |
      | Zipcode       | 06000          |
      | Mobile Number | 05468796564   |
      | Password      | 5677893       |
