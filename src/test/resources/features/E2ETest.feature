Feature: As a user I am able to purchase the product successfully.

  Background:
    Given the user is on the Swaglabs login page.
    And the user login with "standard_user".
    And the user navigates to the "Products" page successfully.

  @TestCase7 @Smoke
  Scenario: E2E The user able to purchase the product successfully. - Happy Path
    When the user select the products by clicking on add to cart button from product list.
      | Sauce Labs Bike Light | $9.99  |
      | Sauce Labs Backpack   | $29.99 |
    And the user click on cart icon.
    Then the user navigates to the "Your Cart" page successfully.
    And the user should be able to verify the products with price.
      | Sauce Labs Bike Light | $9.99  |
      | Sauce Labs Backpack   | $29.99 |
    When the user click on "CHECKOUT" button.
    And the user navigates to the "Checkout" page successfully.
    And the user add the personal information.
    And the user click on continue button.
    Then the user navigates to the "Overview" page successfully.
    And the user should be able to re-verify the products with price.
      | Sauce Labs Bike Light | $9.99  |
      | Sauce Labs Backpack   | $29.99 |
    And the user should be able to verify the payment information.
    And the user should be able to verify the shipping information.
    And the user should be able to verify the total price payable with tax.
    When the user click on "FINISH" button.
    Then the user navigates to the "Finish" page successfully.
    And the user logout successfully.