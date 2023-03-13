Feature: Saucedemo testing
  In order to use Saucedemo, I want to check Saucedemo's shopping cart

  Background: Login page should be opened
    Given I am on the Saucedemo site Login page

  Scenario: Success message should become, when I try to order selected items from the shopping cart
    When I login as a standard_user
    And I add standard_user items to the shopping cart on the Home page
    And I checkout added items on the Cart page
    And I enter my personal information on the Checkout page
    And I finish ordering items on the Overview page
    Then the Complete page should be displayed
    And the "Thank you for your order!" message should be displayed

  Scenario: The shopping cart should become empty, when I remove all items from the shopping cart
    When I login as a performance_glitch_user
    And I add performance_glitch_user items to the shopping cart on the Home page
    And I remove all added items from the Cart page
    Then the Cart page doesn't contain any item