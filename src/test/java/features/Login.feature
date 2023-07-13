@Login
Feature: Login tests
  Login tests using cucumber

  Background:
    Given I go to page https://todoist.com/
    When click on Login section

  @NegLogin
  Scenario Outline: Negative Login
    Given I introduce credentials <user> and <password>
    And I should see the fail message <message>
    Then I close my browser

    Examples:
      | user                      | password    | message                    |
      | jaime.contreras@gmail.com | hello123!!! | "Wrong email or password." |
      | jaime1contreras@gmail.com | hello12dsad | "Wrong email or password." |
      | jaime1contreras@gmail.com | hello12dsad | "Wrong email or password." |

  @PosLogin
  Scenario: Positive Login
    Given I introduce proper credentials
    And I should see the homepage logo
    Then I close my browser
