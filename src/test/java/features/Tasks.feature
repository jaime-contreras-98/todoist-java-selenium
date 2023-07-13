@Tasks
Feature: Tasks scenarios with Cucumber
  We will create some basic tasks

  Background: Login setup
    Given I go to page https://todoist.com/
    And click on Login section
    When I introduce proper credentials
    Then I should see the homepage logo

  @BasicTask
  Scenario: Create a basic task
    Given I click on inbox section
    When I add a task "firstTask" with "Hola esta es mi primera tarea"
    Then I close my browser

  @BasicTaskToday
  Scenario: Create a basic task for today
    Given I click on inbox section
    When I add a task "firstTask" with "Hola esta es mi primera tarea" for "today"
    Then I close my browser

  @BasicTaskTomorrow
  Scenario: Create a basic task for tomorrow
    Given I click on inbox section
    When I add a task "firstTask" with "Hola esta es mi primera tarea" for "Tomorrow"
    Then I close my browser

  @BasicTaskNextWeek
  Scenario: Create a basic task for tomorrow
    Given I click on inbox section
    When I add a task "firstTask" with "Hola esta es mi primera tarea" for "next week"
    Then I close my browser