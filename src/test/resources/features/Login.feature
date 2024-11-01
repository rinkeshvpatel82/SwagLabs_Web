Feature: As a user I am able to login to Swaglabs web application.

  Background:
    Given the user is on the Swaglabs login page.

  @TestCase1 @Smoke
  Scenario: The user login to the Swaglabs web application successfully. - Happy Path
    When the user enter valid username as a "standard_user".
    And the user enter valid password as a "secret_sauce".
    And the user click on login button.
    Then the user navigates to the "Products" page successfully.

  @TestCase2 @Smoke
  Scenario Outline: The user not able to login with incorrect username. - UnHappy Path
    When the user enter valid username as a "<userName>".
    And the user enter valid password as a "<password>".
    And the user click on login button.
    Then the user able to see the "<error>" message successfully.
    Examples:
      | userName       | password     | error                                                       |
      |                |              | Username is required                                        |
      |                | secret_sauce | Username is required                                        |
      | 1              | secret_sauce | Username and password do not match any user in this service |
      | A              | secret_sauce | Username and password do not match any user in this service |
      | a              | secret_sauce | Username and password do not match any user in this service |
      | %              | secret_sauce | Username and password do not match any user in this service |
      | 12             | secret_sauce | Username and password do not match any user in this service |
      | AB             | secret_sauce | Username and password do not match any user in this service |
      | standard_userr | secret_sauce | Username and password do not match any user in this service |
      | standard_user$ | secret_sauce | Username and password do not match any user in this service |
      | standard_user1 | secret_sauce | Username and password do not match any user in this service |
      | standard_userA | secret_sauce | Username and password do not match any user in this service |
      | standard_use1  | secret_sauce | Username and password do not match any user in this service |
      | standard_use$  | secret_sauce | Username and password do not match any user in this service |
      | standard_usep  | secret_sauce | Username and password do not match any user in this service |
      | standard_useR  | secret_sauce | Username and password do not match any user in this service |
      | standard_use   | secret_sauce | Username and password do not match any user in this service |

  @TestCase3 @Smoke
  Scenario Outline: The user not able to login with incorrect password. - UnHappy Path
    When the user enter valid username as a "<userName>".
    And the user enter valid password as a "<password>".
    And the user click on login button.
    Then the user able to see the "<error>" message successfully.
    Examples:
      | userName      | password      | error                                                       |
      | standard_user |               | Password is required                                        |
      | standard_user | b             | Username and password do not match any user in this service |
      | standard_user | &             | Username and password do not match any user in this service |
      | standard_user | 1             | Username and password do not match any user in this service |
      | standard_user | A             | Username and password do not match any user in this service |
      | standard_user | secret_sauc   | Username and password do not match any user in this service |
      | standard_user | secret_saucee | Username and password do not match any user in this service |
      | standard_user | secret_sauce$ | Username and password do not match any user in this service |
      | standard_user | secret_sauce1 | Username and password do not match any user in this service |
      | standard_user | secret_sauceA | Username and password do not match any user in this service |
      | standard_user | secret_saucp  | Username and password do not match any user in this service |
      | standard_user | secret_sauc1  | Username and password do not match any user in this service |
      | standard_user | secret_saucD  | Username and password do not match any user in this service |
      | standard_user | secret_sauc$  | Username and password do not match any user in this service |