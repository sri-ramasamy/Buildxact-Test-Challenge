Feature: Reset Password

Scenario: Reset password
Given User launch Chrome browser
    When user opens URL "https://app-v2-staging.buildxact.com/login"
    And user enters email as "srividya02@email.ghostinspector.com" and password as "Test@4567"
    And user clicks on login button
   And user clicks on my profile
   And user clicks on reset password
   And user clicks on log out link
   And user opens URL "https://email.ghostinspector.com/srividya02@email.ghostinspector.com"
   And user clicks on Reset link
   And user clicks on Reset Password button
   And user enters the new password as "Test@3456"
   And user submits new password
   And close browser

Scenario: Verify new password login to dashboard page
Given User launch Chrome browser
   When user opens URL "https://app-v2-staging.buildxact.com/login"
   And user enters email as "srividya02@email.ghostinspector.com" and password as "Test@3456"
   And user clicks on login button
   Then page title of landing page is "Buildxact-stg: Dashboard"
   When user clicks on log out link
   Then page title of landing page is "Buildxact-stg: Login" 
   And close browser
   
 Scenario: Verify login with old password throws error message
Given User launch Chrome browser
	When user opens URL "https://app-v2-staging.buildxact.com/login"
   And user enters email as "srividya02@email.ghostinspector.com" and password as "Test@4567"
   And user clicks on login button
   Then error message is displayed
   And close browser