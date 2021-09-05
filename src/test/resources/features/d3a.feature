Feature: d3a login and project creation

  Scenario: login to the d3a page
    Given open the d3a page
    When enter the valid credential
    Then verify if user is able to login

  Scenario: Create a new Project
    Given login with correct credential
    When enter all information
    Then verify project created

  Scenario: Verify new project is added
    Given login with correct credential
    When click on project
    Then verify created project is available

