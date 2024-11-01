Feature: As a user I am able to add the product to cart successfully.

  Background:
    Given the user is on the Swaglabs login page.
    And the user login with "standard_user".
    And the user navigates to the "Products" page successfully.

  @TestCase6 @Smoke
  Scenario: The user add the product to the cart successfully. - Happy Path
    When the user select the products by clicking on add to cart button from product list.
      | Sauce Labs Bike Light | $9.99  |
      | Sauce Labs Backpack   | $29.99 |
    And the user click on cart icon.
    Then the user navigates to the "Your Cart" page successfully.
    And the user should be able to verify the products with price.
      | Sauce Labs Bike Light | $9.99  |
      | Sauce Labs Backpack   | $29.99 |