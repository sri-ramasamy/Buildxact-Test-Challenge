Feature: Add User

Scenario: Successful login with valid credentials
    Given User launch Chrome browser
    When user opens URL "https://app-v2-staging.buildxact.com/login"
    And user enters email as "srividya01@email.ghostinspector.com" and password as "Test@1234"
    And user clicks on login button
    And user clicks on My Business menu
    And user clicks on Users radio button
    And user clicks on Add User icon
    And user enters first name
    And user enters last name
    And user enters email
    And user enters phone
    And user clicks on OK button
    And user clicks on log out link
    And user navigates to email "emailURL"
    And user clicks on welcome mail
    And user activates account
    And user enters the new password as "Test@3456"
   And user submits new password
   And close browser
   
Scenario: Verify new user login to dashboard page
Given User launch Chrome browser
   When user opens URL "https://app-v2-staging.buildxact.com/login"
   And user provides email as "newmailid" and password as "Test@3456"
   Then page title of landing page is "Buildxact-stg: Dashboard"
   When user clicks on log out link
   Then page title of landing page is "Buildxact-stg: Login" 
   And close browser
    