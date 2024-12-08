Feature: Delete user

  Background: 
    Given Click on Signuplogin option

  Scenario: Validate the user account gets deleted(TC_Delete_001)
    When Enter existing user email and password
    And click login button
    When delete user account
    Then Validate the user account gets deleted

  Scenario: Validate logging into the application using deleted account details(TC_Delete_002)
    When Enter deleted user email and password
    And click login button
    Then Validate logging into the application using deleted account details

  Scenario: Validate navigating back in the browser after user account deletion(TC_Delete_003)
    When create a new user account using mandatory fields
    And delete user account
    When navigate back in browser
    Then validate navigating back in the browser after user account deletion
