Feature: Search Product

  Background: 
    Given Click on Products option
@sanity
  Scenario: Validate navigation to search page(TC_Search_001)
    Then Validate the Products page is loaded
@sanity
  Scenario: Validate Search a product via search button(TC_Search_002)
    When Enter name of a product in search bar and click on search button
    Then Validate Search a product via search button
@sanity
  Scenario: Validate search bar placeholder(TC_Search_003)
    Then Validate search bar placeholder
@sanity
  Scenario: Validate Search a product via pressing Enter key(TC_Search_004)
    When Enter name of a product in search bar and click enter key
    Then Validate Search a product via pressing Enter key

  Scenario: Validate search product details are loaded when click on the product(TC_Search_005)
    When Enter name of a product in search bar and click on search button
    And Click on view product
    Then Validate search product details are loaded when click on the product

  Scenario: Validate search product details are loaded when click on the product(TC_Search_006)
    When Enter name of a product in search bar and click on search button
    And Click on view product
    Then Validate Availability, Brand, Condition, Category and Price are displayed
