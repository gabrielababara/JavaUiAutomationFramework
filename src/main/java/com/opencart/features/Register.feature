Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

   @Regresion

  Scenario: Register Page can be accessed from the Home Page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    Given "/" endpoint is accessed
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @run
  Scenario: An error message is displayed when invalid First Name is used for Register Flow
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    And the Register Form is populated with the following data:
      | firstName | 98765432456781232123445123456712345678123456789 |
      | lastName  | Secu                                            |
      | email     | andrei.s3c22u@gmail.com                         |
      | password  | Andrei123!                                      |
    When Continue button is clicked
    Then the following list of error messages is displayed:
      | First Name must be between 1 and 32 characters! |

  @run
  Scenario Outline: Error message is displayed when using invalid data for register flow
    Given "/index.php?route=account/register" endpoint is accessed
    When the Register form is populated with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <emailData> |
      | password  | <password>  |
    And Continue Button is clicked
    And the following list of error messages is displayed:
      | Warning: You must agree to the Privacy Policy!     |
      | <errorField> must be between 1 and 32 characters!> |
    Examples:
      | firstName                  | lastName              | emailData | password | errorField |
      | 12324325432543232233222332 | test                  | test      | test     | First Name |
      | valid                      | 123432543243254321123 | test      | test     | Last Name  |
