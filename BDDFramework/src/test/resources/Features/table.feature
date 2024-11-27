
Feature: Get information of Dynamic Table 


Scenario: Verify the total number of company names
    Given I open the browser and navigate to the company page
    When I locate the list of company names on the webpage
    Then I should count the total number of company names and total value of pricelist displayed
    And close the website
