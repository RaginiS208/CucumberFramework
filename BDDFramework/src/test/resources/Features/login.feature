
Feature: Login Page Automation


Scenario: Check Login is successful with valid credentials
Given User launches the application on "<browser>"
When User enters valid username "<username>" and password "<password>"
And User clicks on Login button
Then User should be able to Navigated to Home Page
And close the browser

Examples:
      | browser   | username| password   |
      | chrome    | student | Password123    |
      | firefox   | student | Password123    |
      
# Scenario for invalid credentials
Scenario: Check Login is unsuccessful with invalid credentials
Given User launches the application on "<browser>"
When User enters invalid username "<username>" and password "<password>"
And User clicks on Login button
Then User should be shown invalid credential message
And close the browser

Examples:
      | browser   | username| password   |
      | chrome    | student1 | Password123    |
      | firefox   | student1 | Password123    |