Feature: My Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|sachin124578@gmail.com|sachin124578|

Scenario:
Given user is on Accounts Page
When user gets the tite of the page
Then page title should be "My account - My Store"

Scenario:
Given user is on Accounts Page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6

