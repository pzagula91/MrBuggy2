Feature: Login
  As any user
  I want to log in to the system
  So that I will have access to the system functions

  Scenario Outline: Log in to the system
    Given I go to login page
    When I enter e-mail address "<email>"
    And I enter password "<password>"
    And I click button Login
    Then <expectedResult>

    Examples:
      | email           | password   | expectedResult     |
      | admin@tc2014.pl | 12qwAS     | I am logged in     |
      | admin@tc2014.pl | BadPass123 | I am not logged in |
      | admin@tc2014.pl |            | I am not logged in |
      |                 | 12qwAS     | I am not logged in |
      |                 |            | I am not logged in |
      | no@mail.com     | BadPass123 | I am not logged in |