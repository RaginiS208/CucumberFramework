# CucumberFramework

This is an automation framework using Selenium, Java and Cucumber to test specific features of a sample web application. 

1. Scope: This includes 3 feature files: 
login.feature: Automate the login functionality (successful login and failure scenarios).
table.feature : Validate a dynamic table (e.g. verify data matches given criteria or calculate total from column values).
dropdown.feature: Test a dropdown that dynamically updates based on other inputs (e.g. cascading dropdowns).


2. Framework Features:
Use Page Object Model (POM) for test organization & integrate with Cucumber for behavior-driven development.
Implement reusable utilities (e.g. reading properties, logging).
Support for running tests on multiple browsers.

3. Environment:
Used Maven for build and dependency management.

4. Reporting:
Generate  reports using a library like ExtentReports.
