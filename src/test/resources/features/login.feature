Feature: User Login

  Background: 
    Given Click on Signup_Login option

  Scenario: Validate Login using valid email and password(TC_Login_001)
    When Enter valid login email address
    And Enter valid login password
    And click login
    Then validate login using valid email and password

  Scenario: Validate login using invalid email and valid password(TC_Login_002)
    When Enter invalid login email
    And Enter valid login password
    And click login
    Then Validate login using invalid email and valid password

  Scenario: Validate login using valid email and invalid password(TC_Login_003)
    When Enter valid login email address
    And Enter invalid login password
    And click login
    Then Validate login using valid email and invalid password

  Scenario: Validate login using invalid email and invalid password(TC_Login_004)
    When Enter invalid login email
    And Enter invalid login password
    And click login
    Then Validate login using invalid email and invalid password

  Scenario: Validate login using invalid email format and valid password(TC_Login_005)
    When Enter invalid login email with missing @gmail.com
    And Enter valid login password
    And click login
    Then Validate login using invalid email format and valid password

  Scenario: Validate login without email and valid password(TC_Login_006)
    When Enter valid login password
    And click login
    Then Validate login without email and valid password

  Scenario: Validate login with valid email and missing password(TC_Login_007)
    When Enter valid login email address
    And click login
    Then Validate login with valid email and missing password

  Scenario: Validate login with blank email and password fields(TC_Login_008)
    When click login
    Then Validate login with blank email and password fields

  Scenario: Validate placeholder for emailaddress and password fields (TC_Login_009)
    Then Validate placeholder for emailaddress and password fields

  Scenario: Validate Login and browsing back using Browser back button (TC_Login_010)
    When Enter valid login email address
    And Enter valid login password
    And click login
    When Navigate back using browser back button
    Then Validate Login and browsing back using Browser back button

  Scenario: Validate Loggingout from the Application and browsing back using Browser back button(TC_Login_011)
    When Enter valid login email address
    And Enter valid login password
    And click login
    When click logout
    And Navigate back using browser back button
    Then Validate Loggingout from the Application and browsing back using Browser back button

  Scenario: Validate the text into the Password field is toggled(TC_Login_012)
    When Enter valid login password
    Then Validate the text into the Password field is toggled

  Scenario: Validate the Password is not visible in the Page Source(TC_Login_013)
    When Enter valid login password
    Then Validate the Password is not visible in the Page Source
