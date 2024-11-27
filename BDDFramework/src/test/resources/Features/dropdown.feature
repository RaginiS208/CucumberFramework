Feature: Cascading Dropdown Functionality

Scenario: Verify "From" and "To" dropdowns on MakeMyTrip
    Given I navigate to the MakeMyTrip homepage
    When I close any pop-ups if present
    And I select "Delhi" from the "From" dropdown
    And I select "Mumbai" to the "To" dropdown
    Then I should see the "To" city is correctly selected as "Mumbai"