Feature: Register User

  Background: 
    Given Click on Signup/Login option

  Scenario: Validate Signup with emptyName field and valid email(TC_Register_001)
    When Enter valid email address
    Then Click on Signup
    And validate Signup with emptyName field

  Scenario: Validate Signup with valid name and empty email address filed(TC_Register_002)
    When Enter valid name
    Then Click on Signup
    And validate Signup with emptyEmail field

  Scenario: Validate Signup with empty Name and Email Address field(TC_Register_003)
    Then Click on Signup
    And validate Signup with empty Name and Email Address field

  Scenario: Validate Signup with valid name and invalid email format(TC_Register_004)
    When Enter valid name
    And Enter email with missing @gmail.com
    Then Click on Signup
    And validate Signup with valid name and invalid email format

  Scenario: Validate Signup with existing user details(TC_Register_005)
    When Enter existing user name and email address in the respective fields
    Then Click on Signup
    And validate Signup with existing user details

  Scenario: Validate Signup filling correctly all the Account info fields(TC_Register_006)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory and non-mandatory fields of account info page with valid data
    And Click Create Account
    Then Validate account creation
    When Click continue to login
    Then Validate Signup

  Scenario: Validate Signup filling correctly only the mandatory Account info fields(TC_Register_007)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill only mandatory fields of account info page with valid data
    And Click Create Account
    Then Validate account creation
    When Click continue to login
    Then Validate Signup

  Scenario: Validate Signup leaving password field empty in Account info fields(TC_Register_008)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the password field empty
    And Click Create Account
    Then Validate Signup leaving password field in Account info field empty

  Scenario: Validate Signup leaving First Name field empty in Account info fields(TC_Register_009)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the FirstName field empty
    Then Click Create Account
    And Validate Signup leaving FirstName field empty in Account info field

  Scenario: Validate Signup leaving Last Name field empty in Account info field(TC_Register_010)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the LastName field empty
    And Click Create Account
    Then Validate Signup leaving Last Name field empty in Account info field

  Scenario: Validate Signup leaving Address Line 1 field empty in Account info field(TC_Register_011)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the AddressLine1 field empty
    And Click Create Account
    Then Validate Signup leaving Address Line1 field empty in Account info field

  Scenario: Validate Signup leaving State field empty in Account info field(TC_Register_012)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the State field empty
    And Click Create Account
    Then Validate Signup leaving State field empty in Account info field

  Scenario: Validate Signup leaving City field empty in Account info field(TC_Register_013)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the City field empty
    And Click Create Account
    Then Validate Signup leaving City field empty in Account info field

  Scenario: Validate Signup leaving zipcode field empty in Account info fields(TC_Register_014)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the zipcode field empty
    And Click Create Account
    Then Validate Signup leaving zipcode field empty in Account info fields

  Scenario: Validate Signup leaving Mobile Number field empty in Account info fields(TC_Register_015)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details leave the Mobile Number field empty
    And Click Create Account
    Then Validate Signup leaving Mobile Number field empty in Account info fields

  Scenario: Validate Signup leaving all the fields of Account info empty(TC_Register_016)
    When Enter valid name
    And Enter valid email address
    And Click on Signup
    Then Click on Create Account
    And validate Signup leaving all the fields of Account info empty

  Scenario: Validate Name field in account info matches the Signup name(TC_Register_017)
    When Enter valid name
    And Enter valid email address
    Then Click on Signup
    And validate Name field in account info matches the Signup name

  Scenario: Validate Email field in account info matches the Signup email(TC_Register_018)
    When Enter valid name
    And Enter valid email address
    Then Click on Signup
    And validate Email field in account info matches the Signup email

  Scenario: Validate Email field in account info is disabled(TC_Register_019)
    When Enter valid name
    And Enter valid email address
    Then Click on Signup
    And validate Email field in account info is disabled

  Scenario: Validate mobile number field of account info does not take alphabets as input(TC_Register_020)
    When Enter valid email address
    And Enter valid name
    Then Click on Signup
    When Fill all mandatory details and supply alphabets in mobile number field
    And Click Create Account
    Then Validate mobile number field of account info does not take alphabets as input

  Scenario: Validate all the mandatory fields are marked as mandatory(*)(TC_Register_021)
    When Enter valid name
    And Enter valid email address
    Then Click on Signup
    And Validate all the mandatory fields are marked as mandatory
