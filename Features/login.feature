Feature: Login

Scenario: Successful login with valid credentials
    Given User launch Chrome browser
    When user opens URL "https://app-v2-staging.buildxact.com/login"
    And user enters email as "srividya01@email.ghostinspector.com" and password as "Test@1234"
    And user clicks on login button
    Then page title of landing page is "Buildxact-stg: Dashboard"
    When user clicks on log out link
    Then page title of landing page is "Buildxact-stg: Login"
    And close browser