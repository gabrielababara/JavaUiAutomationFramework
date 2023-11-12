Feature: Login Flow Test Suite

  @run
  Scenario Outline: An error message is displayed when trying to log in with invalid <attribute>
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    And the following set of credentials is enterred into the login form:
      | <email>    |
      | <password> |
    When login button is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute                       | email           | password        |
      | email input data (not existent) | valid@email.com | wrong email     |
      | password input data             | valid@email.com | wrong passwords |
