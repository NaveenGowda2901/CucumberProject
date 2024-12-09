Feature: Usre login DDT

  Scenario Outline: DDT for user login
    Given user clicks on signin link on homepage
    Then verify user login for different set of inputs "<email>" "<password"> "<status>"

    Examples: 
      | email                     | password           | status                  |
      | khkkknksdgjg@gmail.com    | Password123        | invalidemail            |
      | framework@gmail.com       | incorrectpassword  | invalidpassword         |
      | abcdg                     | invalidemailformat | invalidemailformat      |
      | framework@gmail.com       | Password123        | valid                   |
      |                           | missingemail       | missingemail            |
      | missingpassword@gmail.com |                    | missingpassword         |
      |                           |                    | missingemailandpassword |
