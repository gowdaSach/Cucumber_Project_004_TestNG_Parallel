Feature: Login page Feature

Scenario: Login Page Title
Given user is on login page
When user gets the tite of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password Link
Given user is on login page
Then forgot your password  link should be displayed

Scenario: Login with valid Credentials
Given user is on login page
When user enters username "sachin124578@gmail.com"
And user enters password "sachin124578"
And user clicks on Login button
Then user gets the tite of the page
And page title should be "My account - My Store"
